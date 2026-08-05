package com.drashti.bankmanagement.repository;

//AccountRepository
//│
//├── save(Account account)
//├── findById(String accountNumber)
//├── findAll()
//├── deleteById(String accountNumber)
//├── existsById(String accountNumber)
//├── findByCustomerId(String customerId)
//└── existsByCustomerId(String customerId)

import com.drashti.bankmanagement.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
    private final Map<String, Account> accounts = new HashMap<>();

    public void save(Account account) {
        if(account == null) throw new IllegalArgumentException("Account cannot be null");
        accounts.put(account.getAccountNumber(), account);
    }

    public Account findById(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public List<Account> findByCustomerId(String customerId) {
        List<Account> accs = new ArrayList<>();
        for(Account account :  accounts.values()) {
            if(account.getCustomer().getCustomerId().equals(customerId))
                accs.add(account);
        }
        return accs;
    }

    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }

    public void deleteById(String accountNumber) {
        accounts.remove(accountNumber);
    }

    public boolean existsById(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public boolean existsByCustomerId(String customerId) {
        return !findByCustomerId(customerId).isEmpty();
    }


}
