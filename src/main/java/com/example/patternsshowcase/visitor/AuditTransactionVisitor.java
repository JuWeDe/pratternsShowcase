package com.example.patternsshowcase.visitor;

import com.example.patternsshowcase.model.Transaction;

public class AuditTransactionVisitor implements TransactionVisitor {
    @Override
    public void visit(Transaction transaction) {
        System.out.println("Auditing transaction: ID=" + transaction.getId() +
                ", Type=" + transaction.getType() +
                ", Amount=" + transaction.getAmount());
    }
}