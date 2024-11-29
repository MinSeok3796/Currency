package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.ExchangeRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class ExchangeResponseDto {
    private Long id;
    private Long userId;
    private Long currencyId;
    private Double amountInKrw;
    private Double amountAfterExchange;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ExchangeResponseDto() {}

    public ExchangeResponseDto(ExchangeRequest exchangeRequest) {
        this.id = exchangeRequest.getId();
        this.userId = exchangeRequest.getUser().getId();
        this.currencyId = exchangeRequest.getToCurrency().getId();
        this.amountInKrw = exchangeRequest.getAmountInKrw();
        this.amountAfterExchange = exchangeRequest.getAmountAfterExchange();
        this.status = exchangeRequest.getStatus();
        this.createdAt = exchangeRequest.getCreatedAt();
        this.modifiedAt = exchangeRequest.getModifiedAt();
    }
}