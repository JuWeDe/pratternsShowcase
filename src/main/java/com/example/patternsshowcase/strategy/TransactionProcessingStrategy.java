package com.example.patternsshowcase.strategy;


import com.example.patternsshowcase.model.Transaction;

public interface TransactionProcessingStrategy {
    void process(Transaction transaction);
}
