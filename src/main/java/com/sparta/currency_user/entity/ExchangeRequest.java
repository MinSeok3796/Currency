package com.sparta.currency_user.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ExchangeRequest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_currency_id", nullable = false)
    private Currency toCurrency;

    private Double amountInKrw;

    private Double amountAfterExchange;

    private String status;

    public ExchangeRequest(User user, Currency toCurrency, Double amountInKrw, Double amountAfterExchange, String status) {
        this.user = user;
        this.toCurrency = toCurrency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;

    }

    public ExchangeRequest() {}

    public void setStatus(String status){
        this.status = status;
    }

}
