package com.example.patternsshowcase.config;

import com.example.patternsshowcase.strategy.FraudCheckTransactionProcessing;
import com.example.patternsshowcase.strategy.StandardTransactionProcessing;
import com.example.patternsshowcase.strategy.TransactionProcessingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class TransactionStrategyConfig {

    @Bean
    public Map<String, TransactionProcessingStrategy> strategyMap() {
        return Map.of(
                "standard", new StandardTransactionProcessing(),
                "fraudcheck", new FraudCheckTransactionProcessing()
        );
    }
}