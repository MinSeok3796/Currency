package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.service.ExchangeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchange-requests")
@RequiredArgsConstructor
public class ExchangeRequestController {

    private final ExchangeRequestService exchangeRequestService;

    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchangeRequest(@RequestBody ExchangeRequestDto exchangeRequestDto) {
        ExchangeResponseDto responseDto = exchangeRequestService.createExchangeRequest(exchangeRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangeRequestsByUser(@PathVariable Long userId) {
        List<ExchangeResponseDto> responseDtos = exchangeRequestService.getExchangeRequestsByUserId(userId);
        return ResponseEntity.ok(responseDtos);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<ExchangeResponseDto> cancelExchangeRequest(@PathVariable Long id) {
        ExchangeResponseDto responseDto = exchangeRequestService.cancelExchangeRequest(id);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteExchangeRequestsByUser(@PathVariable Long userId) {
        exchangeRequestService.deleteExchangeRequestsByUserId(userId);
        return ResponseEntity.ok("Customer and their exchange requests deleted successfully.");
    }
}
