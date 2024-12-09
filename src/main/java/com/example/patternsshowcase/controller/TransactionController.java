package com.example.patternsshowcase.controller;


import com.example.patternsshowcase.model.Transaction;
import com.example.patternsshowcase.observer.CustomerNotifier;
import com.example.patternsshowcase.observer.TransactionLogger;
import com.example.patternsshowcase.service.TransactionService;
import com.example.patternsshowcase.strategy.FraudCheckTransactionProcessing;
import com.example.patternsshowcase.strategy.StandardTransactionProcessing;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController() {
        // Создаем сервис транзакций
        this.transactionService = new TransactionService();

        // Добавляем наблюдателей (Observer)
        transactionService.addObserver(new TransactionLogger());
        transactionService.addObserver(new CustomerNotifier());
    }

    @PostMapping
    public Transaction createTransaction(@RequestParam String type, @RequestParam BigDecimal amount) {
        return transactionService.createTransaction(type, amount);
    }

    @PostMapping("/{transactionId}/process")
    public void processTransaction(@PathVariable String transactionId, @RequestParam String mode) {
        if ("standard".equalsIgnoreCase(mode)) {
            transactionService.setStrategy(new StandardTransactionProcessing());
        } else if ("fraudCheck".equalsIgnoreCase(mode)) {
            transactionService.setStrategy(new FraudCheckTransactionProcessing());
        } else {
            throw new IllegalArgumentException("Invalid processing mode: " + mode);
        }
        transactionService.processTransaction(transactionId);
    }
}
