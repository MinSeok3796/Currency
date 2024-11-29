package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.ExchangeRequest;
import com.sparta.currency_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRequestRepository extends JpaRepository<ExchangeRequest, Long> {
    List<ExchangeRequest> findByUser(User user);
    void deleteByUser(User user);
}
