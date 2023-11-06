package com.acmebank.quarkus.exception;

public class BankAccountNotFoundException extends RuntimeException {

    public BankAccountNotFoundException(String exception) {
        super(exception);
    }

}
