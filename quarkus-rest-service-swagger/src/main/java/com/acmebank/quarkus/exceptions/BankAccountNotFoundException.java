package com.acmebank.quarkus.exceptions;

public class BankAccountNotFoundException extends RuntimeException{

    public BankAccountNotFoundException(String exception) {
        super(exception);
    }
}
