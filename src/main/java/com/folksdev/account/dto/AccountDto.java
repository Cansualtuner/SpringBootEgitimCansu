package com.folksdev.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Stream;

//SOLID = OPENCLOSED
public class AccountDto {
    private String id;

    private BigDecimal balance;

    private LocalDateTime creationDate;
    private AccountCustomerDto customer;

    private Set<TransactionDto> transactions;

    public AccountDto(String id, BigDecimal balance, LocalDateTime creationDate, AccountCustomerDto accountCustomerDto) {
    }

    public AccountDto(String id, BigDecimal balance, LocalDateTime creationDate, AccountCustomerDto accountCustomerDto, Stream<TransactionDtoConverter> transactionDtoConverterStream) {
    }
}
