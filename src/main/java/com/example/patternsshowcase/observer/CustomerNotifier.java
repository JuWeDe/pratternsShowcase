package com.example.patternsshowcase.observer;

import com.example.patternsshowcase.model.Transaction;

public class CustomerNotifier implements TransactionObserver {
    @Override
    public void notify(Transaction transaction) {
        System.out.println("Customer notified for transaction: " + transaction.getId());
    }
}
