package com.example.patternsshowcase.observer;

import com.example.patternsshowcase.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionNotifier {
    private final List<TransactionObserver> observers = new ArrayList<>();

    public void addObserver(TransactionObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Transaction transaction) {
        for (TransactionObserver observer : observers) {
            observer.notify(transaction);
        }
    }
}