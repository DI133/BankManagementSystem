package com.drashti.bankmanagement.model;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

    public Employee(String employeeId, String firstName, String lastName, String email, String password, String phoneNumber) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

//    public void setEmployeeId(String employeeId) {
//        this.employeeId = employeeId;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Employee ID: ")
                .append(employeeId)
                .append("\n");

        sb.append("First Name: ")
                .append(firstName)
                .append("\n");

        sb.append("Last Name: ")
                .append(lastName)
                .append("\n");

        sb.append("Email: ")
                .append(email)
                .append("\n");

        sb.append("Phone Number: ")
                .append(phoneNumber)
                .append("\n");

        return sb.toString();
    }
}
