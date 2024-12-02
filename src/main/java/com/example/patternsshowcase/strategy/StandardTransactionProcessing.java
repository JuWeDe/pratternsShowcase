package com.example.patternsshowcase.strategy;


import com.example.patternsshowcase.model.Transaction;

public class StandardTransactionProcessing implements TransactionProcessingStrategy {
    @Override
    public void process(Transaction transaction) {
        transaction.setStatus("COMPLETED");
        System.out.println("Transaction processed successfully: " + transaction.getId());
    }
}
