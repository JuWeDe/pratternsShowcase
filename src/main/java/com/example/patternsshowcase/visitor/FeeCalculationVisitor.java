package com.example.patternsshowcase.visitor;

import com.example.patternsshowcase.model.Transaction;

import java.math.BigDecimal;

public class FeeCalculationVisitor implements TransactionVisitor {
    @Override
    public void visit(Transaction transaction) {
        BigDecimal fee = transaction.getAmount().multiply(BigDecimal.valueOf(0.02));
        System.out.println("Calculating fee for transaction: ID=" + transaction.getId() +
                ", Fee=" + fee);
    }
}