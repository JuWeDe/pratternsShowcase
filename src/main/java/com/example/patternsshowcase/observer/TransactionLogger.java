package com.example.patternsshowcase.observer;


import com.example.patternsshowcase.model.Transaction;

public class TransactionLogger implements TransactionObserver {
    @Override
    public void notify(Transaction transaction) {
        System.out.println("Transaction Event: " + transaction.getId() + " - Status: " + transaction.getStatus());
    }
}
