package com.example.patternsshowcase.model;

import java.math.BigDecimal;

public class Transaction {
    private String id;
    private String type; // PAYMENT, TRANSFER, REFUND
    private BigDecimal amount;
    private String status; // PENDING, COMPLETED, FAILED

    public Transaction(String id, String type, BigDecimal amount, String status) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}