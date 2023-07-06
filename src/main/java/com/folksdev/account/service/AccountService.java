package com.folksdev.account.service;


import com.folksdev.account.dto.AccountDto;
import com.folksdev.account.dto.AccountDtoConverter;
import com.folksdev.account.dto.CreateAccountRequest;
import com.folksdev.account.model.Account;
import com.folksdev.account.model.Customer;
import com.folksdev.account.model.Transaction;
import com.folksdev.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class AccountService {
    private final AccountRepository  accountRepository;
    private final CustomerService customerService;
    private TransacionService transacionService;
    private final AccountDtoConverter converter;


    public AccountService(AccountRepository accountRepository, CustomerService customerService, AccountDtoConverter accountDtoConverter, Clock clock, Supplier<UUID> uuidSupplier) {
        TransacionService transacionService1;
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = accountDtoConverter;
    }
    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(createAccountRequest.getInitialCredit(),
                LocalDateTime.now(),
                customer);

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
            Transaction transaction = transacionService.initialMoney(account,createAccountRequest.getInitialCredit());
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));

    }


}
