package com.example.patternsshowcase.model;

import com.example.patternsshowcase.visitor.TransactionVisitor;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {
    private final String id;
    private final String type;
    private final BigDecimal amount;
    private String status;

    public Transaction(String type, BigDecimal amount) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.amount = amount;
        this.status = "PENDING";
    }

    // Геттеры для сериализации
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Поддержка Visitor
    public void accept(TransactionVisitor visitor) {
        visitor.visit(this);
    }
}