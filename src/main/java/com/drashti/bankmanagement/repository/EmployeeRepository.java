package com.drashti.bankmanagement.repository;


import com.drashti.bankmanagement.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    private final Map<String, Employee> employees = new HashMap<>();

    public void save(Employee employee) {
        if(employee == null)
            throw new IllegalArgumentException("Employee cannot be null");
        employees.put(employee.getEmployeeId(), employee);
    }

    public Employee findById(String employeeId) {
        return employees.get(employeeId);
    }

    public Employee findByEmail(String email) {
        for(Employee employee : employees.values()){
            if(employee.getEmail().equals(email)){
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public void deleteById(String employeeId) {
        employees.remove(employeeId);
    }

    public boolean existsById(String employeeId) {
        return employees.containsKey(employeeId);
    }

    public boolean existsByEmail(String email) {
        return findByEmail(email) != null;
    }
}
