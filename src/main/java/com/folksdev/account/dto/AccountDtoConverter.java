package com.folksdev.account.dto;

import com.folksdev.account.model.Account;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountDtoConverter {
    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter){
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from){
        return new AccountDto(from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.convertToAccountCustomer(from.getCustomer()),
                (Stream<TransactionDtoConverter>) from.getTransaction().stream().map(t -> transactionDtoConverter.convert(t)).collect(Collectors.toSet()));


    }

}
