package com.training.mike.bank.service;

import com.training.mike.bank.model.TransferBalance;
import com.training.mike.bank.repository.BankRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

    private final BankRepository repository;

    public BigDecimal getBalance(Long accountId) {
        BigDecimal balance = repository.getBalanceById(accountId);
        if (balance == null) {
            throw new IllegalArgumentException("Shize!");
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        BigDecimal currentBalance = repository.getBalanceById(to);
        if (currentBalance == null) {
            repository.save(to, amount);
            return amount;
        } else {
            repository.save(to, currentBalance.add(amount));
        }
        return currentBalance.add(amount);
    }

    public void makeTransfer(TransferBalance transferBalance) {
        BigDecimal fromBalance = repository.getBalanceById(transferBalance.getFrom());
        BigDecimal toBalance = repository.getBalanceById(transferBalance.getTo());
        if (fromBalance == null || toBalance == null) {
            throw new IllegalArgumentException();
        }
        if (transferBalance.getAmount().compareTo(fromBalance) > 0) {
            throw new IllegalArgumentException("Not enough founds");
        }
        BigDecimal updatedFromBalance = fromBalance.subtract(transferBalance.getAmount());
        BigDecimal updatedToBalance = toBalance.add(transferBalance.getAmount());
        repository.save(transferBalance.getFrom(), updatedFromBalance);
        repository.save(transferBalance.getTo(), updatedToBalance);
    }
}


