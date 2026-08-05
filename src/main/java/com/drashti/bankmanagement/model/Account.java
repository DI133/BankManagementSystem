package com.drashti.bankmanagement.model;

import com.drashti.bankmanagement.enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private AccountType accountType;
    private double balance;
    private Customer customer;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, AccountType accountType, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public Account(String accountNumber, AccountType accountType, double balance, Customer customer, List<Transaction> transactions) {
        this(accountNumber, accountType, balance, customer);
        if(transactions != null)
            this.transactions = new ArrayList<>(transactions);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // not modifiable
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    public AccountType getAccountType() {
        return accountType;
    }

//    public void setAccountType(AccountType accountType) {
//        this.accountType = accountType;
//    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public List<Transaction> getTransactions() {
        // return transactions;
        return List.copyOf(transactions);
    }

//    public void setTransactions(List<Transaction> transactions) {
//        if(transactions != null)
//            this.transactions = transactions;
//        else
//            this.transactions = new ArrayList<>();
//    }

    public void addTransaction(Transaction transaction) {
        if(transaction != null)
            transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        if(transaction != null)
            transactions.remove(transaction);
    }


    @Override
    public String toString() {
        // Account details
        StringBuilder sb = new StringBuilder();

        sb.append("Account Number: ")
                .append(accountNumber)
                .append("\n");

        sb.append("Account Type: ")
                .append(accountType)
                .append("\n");

        sb.append("Balance: ")
                .append(balance)
                .append("\n");

        sb.append("Account Holder of this account: ")
                .append(customer.getFirstName() +  " " + customer.getLastName())
                .append("\n");

        sb.append("Total Transactions: ")
                .append(transactions.size())
                .append("\n");

        return sb.toString();
    }

}
