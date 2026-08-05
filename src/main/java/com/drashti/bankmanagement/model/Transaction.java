package com.drashti.bankmanagement.model;

import com.drashti.bankmanagement.enums.TransactionType;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private TransactionType transactionType;
    private double amount;
    private LocalDateTime transactionDateTime;
    private Account account;

    public Transaction(String transactionId, TransactionType transactionType, double amount, Account account) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDateTime = LocalDateTime.now();
        this.account = account;
    }

    public String getTransactionId() {
        return transactionId;
    }

//    public void setTransactionId(String transactionId) {
//        this.transactionId = transactionId;
//    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

//    public void setTransactionType(TransactionType transactionType) {
//        this.transactionType = transactionType;
//    }

    public double getAmount() {
        return amount;
    }

//    public void setAmount(double amount) {
//        this.amount = amount;
//    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

//    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
//        this.transactionDateTime = transactionDateTime;
//    }

    public Account getAccount() {
        return account;
    }

//    public void setAccount(Account account) {
//        this.account = account;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction Id: ")
                .append(transactionId)
                .append("\n");

        sb.append("Transaction Type: ")
                .append(transactionType)
                .append("\n");

        sb.append("Transaction Amount: ")
                .append(amount)
                .append("\n");

        sb.append("Transaction DateTime: ")
                .append(transactionDateTime)
                .append("\n");

        sb.append("Account Number: ")
                .append(account.getAccountNumber())
                .append("\n");

        sb.append("Account Holder ID: ")
                .append(account.getCustomer().getCustomerId())
                .append("\n");


        sb.append("Account Holder Name: ")
                .append(account.getCustomer().getFirstName() + " " + account.getCustomer().getLastName())
                .append("\n");

        return sb.toString();
    }
}
