package com.folksdev.account.dto;

import com.folksdev.account.model.TransactionType;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private String id;

    //val transactionType: TransactionType? = TransactionType, INITIAL
    private TransactionType transactionTypee;
    private LocalDateTime transactionDate ;

    public TransactionDto(String id, TransactionType transactionType, BigDecimal amount, LocalDateTime transactionDate) {
    }
}
