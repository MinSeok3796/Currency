package com.sparta.currency_user.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ExchangeRequest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "to_currency_id", nullable = false)
    private Currency toCurrency;

    private Double amountInKrw;

    private Double amountAfterExchange;

    private String status;




}
