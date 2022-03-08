package com.training.mike.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class Adviser {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
    log.error(e.getMessage());
    return "All was gone ...";
    }
}
