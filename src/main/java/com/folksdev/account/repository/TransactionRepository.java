package com.folksdev.account.repository;

import com.folksdev.account.model.Transaction;

public interface TransactionRepository {


    Transaction save(Transaction transaction);
}
