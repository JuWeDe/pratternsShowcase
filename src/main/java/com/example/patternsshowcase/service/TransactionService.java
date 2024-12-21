package com.example.patternsshowcase.service;

import com.example.patternsshowcase.model.Transaction;
import com.example.patternsshowcase.observer.TransactionNotifier;
import com.example.patternsshowcase.strategy.TransactionProcessingStrategy;
import com.example.patternsshowcase.strategy.TransactionProcessingStrategyRegistry;
import com.example.patternsshowcase.visitor.TransactionVisitor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {

    private final Map<String, Transaction> transactions = new HashMap<>();
    private final TransactionNotifier notifier = new TransactionNotifier();
    private final TransactionProcessingStrategyRegistry strategyRegistry;

    public TransactionService(TransactionProcessingStrategyRegistry strategyRegistry) {
        this.strategyRegistry = strategyRegistry;
    }

    public Transaction createTransaction(String type, BigDecimal amount) {
        Transaction transaction = new Transaction(type, amount);
        transactions.put(transaction.getId(), transaction);
        notifier.notifyObservers(transaction);
        return transaction;
    }

    public void processTransaction(String transactionId, String mode) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction not found: " + transactionId);
        }

        TransactionProcessingStrategy strategy = strategyRegistry.getStrategy(mode);
        strategy.process(transaction);
        notifier.notifyObservers(transaction);
    }

    public void applyVisitor(String transactionId, TransactionVisitor visitor) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction not found: " + transactionId);
        }

        transaction.accept(visitor);
    }
}