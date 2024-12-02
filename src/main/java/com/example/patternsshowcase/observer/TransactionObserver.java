package com.example.patternsshowcase.observer;

import com.example.patternsshowcase.model.Transaction;

public interface TransactionObserver {
    void notify(Transaction transaction);
}