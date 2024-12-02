package com.example.patternsshowcase.strategy;


import com.example.patternsshowcase.model.Transaction;

public class FraudCheckTransactionProcessing implements TransactionProcessingStrategy {
    @Override
    public void process(Transaction transaction) {
        if (transaction.getAmount().compareTo(new java.math.BigDecimal("10000")) > 0) {
            transaction.setStatus("FAILED");
            System.out.println("Transaction flagged as fraudulent: " + transaction.getId());
        } else {
            transaction.setStatus("COMPLETED");
            System.out.println("Transaction processed successfully: " + transaction.getId());
        }
    }
}