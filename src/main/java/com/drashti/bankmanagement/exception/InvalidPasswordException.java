package com.drashti.bankmanagement.exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message){
        super(message);
    }
}
