package com.folksdev.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class CustomerAccountDto {
    private String id;
    private BigDecimal balance;
    private Set<TransactionDto> transactions;
    private LocalDateTime creationDate;


    public <R> CustomerAccountDto(String id, BigDecimal balance, R collect, LocalDateTime creationDate) {

    }
}
