package com.example.patternsshowcase.visitor;

import com.example.patternsshowcase.model.Transaction;

public interface TransactionVisitor {
    void visit(Transaction transaction);
}