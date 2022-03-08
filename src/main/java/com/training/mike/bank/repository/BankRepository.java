package com.training.mike.bank.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

import java.math.BigDecimal;

@Repository
public class BankRepository {

    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, new BigDecimal("10")));

    public BigDecimal getBalanceById(Long accountId) {
        return storage.get(accountId);
    }

    public void save(Long to, BigDecimal amount) {
        storage.put(to, amount);
    }


}
