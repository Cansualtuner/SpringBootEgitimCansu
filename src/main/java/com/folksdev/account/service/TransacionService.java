package com.folksdev.account.service;

import com.folksdev.account.model.Account;
import com.folksdev.account.model.Transaction;
import com.folksdev.account.repository.TransactionRepository;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class TransacionService {
    private Logger logger = (Logger) LoggerFactory.getLogger(TransacionService.class);
    private final TransactionRepository transactionRepository;


    public TransacionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    protected Transaction initialMoney(final Account account,BigDecimal amount){
        return transactionRepository.save(
                new Transaction(amount,account)
        );
    }
}
