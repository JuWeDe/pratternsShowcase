package com.example.patternsshowcase.controller;


import com.example.patternsshowcase.model.Transaction;
import com.example.patternsshowcase.service.TransactionService;
import com.example.patternsshowcase.visitor.AuditTransactionVisitor;
import com.example.patternsshowcase.visitor.FeeCalculationVisitor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Создать новую транзакцию", description = "Позволяет создать транзакцию с указанным типом и суммой")
    @PostMapping
    public Transaction createTransaction(
            @Parameter(description = "Тип транзакции", example = "PAYMENT") @RequestParam String type,
            @Parameter(description = "Сумма транзакции", example = "1500") @RequestParam BigDecimal amount) {
        return transactionService.createTransaction(type, amount);
    }

    @Operation(summary = "Обработать транзакцию", description = "Запускает обработку транзакции с использованием заданной стратегии")
    @PostMapping("/{transactionId}/process")
    public void processTransaction(
            @Parameter(description = "ID транзакции") @PathVariable String transactionId,
            @Parameter(description = "Режим обработки", example = "standard") @RequestParam String mode) {
        transactionService.processTransaction(transactionId, mode);
    }

    @Operation(summary = "Аудит транзакции", description = "Логирует данные транзакции для аудита")
    @PostMapping("/{transactionId}/audit")
    public void auditTransaction(@PathVariable String transactionId) {
        transactionService.applyVisitor(transactionId, new AuditTransactionVisitor());
    }

    @Operation(summary = "Расчет комиссии", description = "Рассчитывает комиссию для указанной транзакции")
    @PostMapping("/{transactionId}/calculate-fee")
    public void calculateFee(@PathVariable String transactionId) {
        transactionService.applyVisitor(transactionId, new FeeCalculationVisitor());
    }
}