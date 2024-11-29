package com.sparta.currency_user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ExchangeRequestDto {
    private Long userId;
    private Long currencyId;
    private Double amountInKrw;

    public ExchangeRequestDto() {}

    public ExchangeRequestDto(Long userId, Long currencyId, Double amountInKrw) {
        this.userId = userId;
        this.currencyId = currencyId;
        this.amountInKrw = amountInKrw;
    }

}