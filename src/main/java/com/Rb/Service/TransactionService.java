package com.Rb.Service;

import com.Rb.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    Transaction getTransactionById(int id);

    String deleteTransaction(int id);

    List getAllTransactions();
}
