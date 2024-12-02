package com.example.patternsshowcase.factory;

import com.example.patternsshowcase.model.Transaction;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionFactory {
    public static Transaction createTransaction(String type, BigDecimal amount) {
        return new Transaction(
                UUID.randomUUID().toString(),
                type,
                amount,
                "PENDING" // Default status
        );
    }
}