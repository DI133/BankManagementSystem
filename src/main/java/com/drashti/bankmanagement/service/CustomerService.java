package com.drashti.bankmanagement.service;

//CustomerService
//│
//├── createCustomer(...)
//├── getCustomerById(String customerId)
//├── getCustomerByEmail(String email)
//├── getAllCustomers()
//├── updateCustomer(...)
//├── deleteCustomer(String customerId)
//├── changePassword(...)
//└── login(...)

import com.drashti.bankmanagement.exception.CustomerNotFoundException;
import com.drashti.bankmanagement.exception.DuplicateEmailException;
import com.drashti.bankmanagement.exception.InvalidPasswordException;
import com.drashti.bankmanagement.model.Customer;
import com.drashti.bankmanagement.repository.CustomerRepository;
import com.drashti.bankmanagement.util.EmailValidator;

import java.util.List;

import static com.drashti.bankmanagement.constants.AppConstants.MAX_PASSWORD_LENGTH;
import static com.drashti.bankmanagement.constants.AppConstants.MIN_PASSWORD_LENGTH;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer){
        if(customer == null)
            throw new IllegalArgumentException("Customer cannot be null");

        // empty fields
        if(customer.getFirstName() == null || customer.getFirstName().isBlank())
            throw new IllegalArgumentException("First name cannot be empty");
        if(customer.getLastName() == null || customer.getLastName().isBlank())
            throw new IllegalArgumentException("Last name cannot be empty");
        if(customer.getEmail() == null || customer.getEmail().isBlank())
            throw new IllegalArgumentException("Email cannot be empty");
        if(customer.getPassword() == null || customer.getPassword().isBlank())
            throw new IllegalArgumentException("Password cannot be empty");
        if(customer.getPhoneNumber() == null || customer.getPhoneNumber().isBlank())
            throw new IllegalArgumentException("Phone number cannot be empty");

        // duplicate email
        if(customerRepository.existsByEmail(customer.getEmail()))
            throw new DuplicateEmailException("Customer with this email already exists");

        if(!EmailValidator.patternMatches(customer.getEmail()))
            throw new IllegalArgumentException("Invalid email address");

        // password validity
        if(customer.getPassword().length() < MIN_PASSWORD_LENGTH)
            throw new IllegalArgumentException("Password length cannot be less than " + MIN_PASSWORD_LENGTH);
        if(customer.getPassword().length() > MAX_PASSWORD_LENGTH)
            throw new IllegalArgumentException("Password length cannot be more than " + MAX_PASSWORD_LENGTH);


        customerRepository.save(customer);
    }

    public Customer getCustomerById(String customerId){
        Customer c = customerRepository.findById(customerId);
        if(c == null){
            throw new CustomerNotFoundException("Customer with "+ customerId + "not found");
        }
        return c;
    }

    public Customer getCustomerByEmail(String email){
        Customer c = customerRepository.findByEmail(email);
        if(c == null){
            throw new CustomerNotFoundException("Customer with "+ email + "not found");
        }
        return c;
    }


    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void deleteCustomer(String customerId){
        customerRepository.deleteById(customerId);
    }

    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void changePassword(String customerId, String newPassword){
        Customer c = getCustomerById(customerId);
        if (newPassword.length() < MIN_PASSWORD_LENGTH ||
                newPassword.length() > MAX_PASSWORD_LENGTH) {

            throw new InvalidPasswordException("Password length cannot be less than " + MIN_PASSWORD_LENGTH + " and cannot be greater than " + MAX_PASSWORD_LENGTH);
        }

        c.updatePassword(newPassword);
    }

    public Customer login(String email, String password){
        Customer c = getCustomerByEmail(email);
        if(c == null){
            throw new CustomerNotFoundException("Customer with "+ email + "not found");
        }
        if(c.getPassword().equals(password)){
            //System.out.println("Login successful");
            return c;
        }
        else {
            throw new InvalidPasswordException("Invalid password");
        }
    }
}

