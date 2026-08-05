package com.drashti.bankmanagement.repository;

//TransactionRepository
//        │
//        ├── save(Transaction transaction)
//        ├── findById(String transactionId)
//        ├── findAll()
//        ├── deleteById(String transactionId)
//        ├── existsById(String transactionId)
//        ├── findByAccountNumber(String accountNumber)
//        ├── findByCustomerId(String customerId)
//        ├── findByTransactionType(TransactionType transactionType)
//        └── findByDate(LocalDate date)

import com.drashti.bankmanagement.enums.TransactionType;
import com.drashti.bankmanagement.model.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository {
    private final Map<String, Transaction> transactions =  new HashMap<>();

    public void save(Transaction transaction) {
        if(transaction == null)
            throw new IllegalArgumentException("Transaction object cannot be null");

        transactions.put(transaction.getTransactionId(), transaction);
    }

    public Transaction findById(String transactionId) {
        return transactions.get(transactionId);
    }

    public List<Transaction> findAll() {
        return new ArrayList<>(transactions.values());
    }

    public void deleteById(String transactionId) {
        transactions.remove(transactionId);
    }

    public boolean existsById(String transactionId) {
        return transactions.containsKey(transactionId);
    }

    public List<Transaction> findByAccountNumber(String accountNumber) {
        List<Transaction> trans = new ArrayList<>();
        for(Transaction t :  transactions.values()){
            if(t.getAccount().getAccountNumber().equals(accountNumber))
                trans.add(t);
        }

        return trans;
    }

    public List<Transaction> findByCustomerId(String customerId) {
        ArrayList<Transaction> trans = new ArrayList<>();
        for(Transaction t :  transactions.values()){
            if(t.getAccount().getCustomer().getCustomerId().equals(customerId))
                trans.add(t);
        }

        return trans;
    }

    public List<Transaction> findByTransactionType(TransactionType transactionType) {
        List<Transaction> trans = new ArrayList<>();
        for(Transaction t :  transactions.values()){
            if(t.getTransactionType().equals(transactionType))
                trans.add(t);
        }
        return trans;
    }

    public List<Transaction> findByDate(LocalDateTime date) {
        List<Transaction> trans = new ArrayList<>();
        for(Transaction t :  transactions.values()){
            if(t.getTransactionDateTime().toLocalDate().equals(date))
                trans.add(t);
        }
        return trans;
    }

}
