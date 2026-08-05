package com.drashti.bankmanagement.exception;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
    }
    public InvalidAmountException(String message) {
        super(message);
    }
}
