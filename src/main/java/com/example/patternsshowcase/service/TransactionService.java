package com.example.patternsshowcase.service;


import com.example.patternsshowcase.factory.TransactionFactory;
import com.example.patternsshowcase.model.Transaction;
import com.example.patternsshowcase.observer.TransactionNotifier;
import com.example.patternsshowcase.observer.TransactionObserver;
import com.example.patternsshowcase.strategy.TransactionProcessingStrategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TransactionService {
    private final Map<String, Transaction> transactions = new HashMap<>();
    private final TransactionNotifier notifier = new TransactionNotifier();
    private TransactionProcessingStrategy strategy;

    public void setStrategy(TransactionProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public Transaction createTransaction(String type, BigDecimal amount) {
        Transaction transaction = TransactionFactory.createTransaction(type, amount);
        transactions.put(transaction.getId(), transaction);
        notifier.notifyObservers(transaction);
        return transaction;
    }

    public void processTransaction(String transactionId) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction != null && strategy != null) {
            strategy.process(transaction);
            notifier.notifyObservers(transaction);
        }
    }

    public void addObserver(TransactionObserver observer) {
        notifier.addObserver(observer);
    }
}