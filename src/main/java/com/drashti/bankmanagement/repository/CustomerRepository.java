package com.drashti.bankmanagement.repository;

//CustomerRepository
//│
//├── save(Customer customer)
//├── findById(String customerId)
//├── findByEmail(String email)
//├── findAll()
//├── deleteById(String customerId)
//├── existsById(String customerId)
//└── existsByEmail(String email)

import com.drashti.bankmanagement.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {

    private final Map<String, Customer> customers = new HashMap<>();

    public void save(Customer customer) {
        if(customer == null)
            throw new IllegalArgumentException("Customer cannot be null");
        customers.put(customer.getCustomerId(), customer);
    }

    public Customer findById(String customerId) {
        return customers.get(customerId);
    }

    public Customer findByEmail(String email) {
        for(Customer customer : customers.values()){
            if(customer.getEmail().equals(email)){
                return customer;
            }
        }
        return null;
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    public void deleteById(String customerId) {
        customers.remove(customerId);
    }

    public boolean existsById(String customerId) {
        return customers.containsKey(customerId);
    }

    public boolean existsByEmail(String email) {
        return findByEmail(email) != null;
    }
}
