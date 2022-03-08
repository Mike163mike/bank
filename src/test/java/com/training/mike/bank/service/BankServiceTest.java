package com.training.mike.bank.service;

import com.training.mike.bank.repository.BankRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//@AutoConfigureMockMvc
class BankServiceTest {

//    @Autowired
//    private MockMvc mockMvc
// Закоментированный код относится к интеграционному тесту для проверки endpoint'ов

    private final BankRepository bankRepository = new BankRepository();
    private final BankService bankService = new BankService(bankRepository);

    @Test
    void getBalance() {
        BigDecimal balance = bankService.getBalance(1L);
        assertEquals(new BigDecimal(10), balance);
    }

    @Test
    void addMoney() {
        BigDecimal balance = bankService.addMoney(1L, new BigDecimal(1));
        assertEquals(new BigDecimal(11), balance);
    }
}