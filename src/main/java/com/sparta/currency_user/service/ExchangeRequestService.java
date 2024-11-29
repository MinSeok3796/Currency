package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.ExchangeRequest;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.ExchangeRequestRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExchangeRequestService {

    private final ExchangeRequestRepository exchangeRequestRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    @Transactional
    public ExchangeResponseDto createExchangeRequest(ExchangeRequestDto exchangeRequestDto) {
        User user = userRepository.findById(exchangeRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Currency currency = currencyRepository.findById(exchangeRequestDto.getCurrencyId())
                .orElseThrow(() -> new IllegalArgumentException("Currency not found"));

        double exchangeRate = currency.getExchangeRate().doubleValue();
        double amountAfterExchange = BigDecimal.valueOf(exchangeRequestDto.getAmountInKrw() / exchangeRate)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        ExchangeRequest exchangeRequest = new ExchangeRequest(user, currency, exchangeRequestDto.getAmountInKrw(), amountAfterExchange, "normal");
        exchangeRequestRepository.save(exchangeRequest);

        return new ExchangeResponseDto(exchangeRequest);
    }

    @Transactional(readOnly = true)
    public List<ExchangeResponseDto> getExchangeRequestsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return exchangeRequestRepository.findByUser(user).stream()
                .map(ExchangeResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ExchangeResponseDto cancelExchangeRequest(Long id) {
        ExchangeRequest exchangeRequest = exchangeRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exchange request not found"));

        exchangeRequest.setStatus("cancelled");
        exchangeRequestRepository.save(exchangeRequest);

        return new ExchangeResponseDto(exchangeRequest);
    }

    @Transactional
    public void deleteExchangeRequestsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        exchangeRequestRepository.deleteByUser(user);
    }
}