package com.example.patternsshowcase.strategy;

import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class TransactionProcessingStrategyRegistry {

    private final Map<String, TransactionProcessingStrategy> strategies;

    public TransactionProcessingStrategyRegistry(Map<String, TransactionProcessingStrategy> strategies) {
        this.strategies = strategies;
    }

    public TransactionProcessingStrategy getStrategy(String mode) {
        TransactionProcessingStrategy strategy = strategies.get(mode.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("No processing strategy found for mode: " + mode);
        }
        return strategy;
    }
}