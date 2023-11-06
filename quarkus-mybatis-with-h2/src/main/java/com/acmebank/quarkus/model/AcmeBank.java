package com.acmebank.quarkus.model;

public class AcmeBank {

    private Long id;

    private String name;

    private String accountNo;

    public AcmeBank() {
        super();
    }

    public AcmeBank(Long id, String name, String accountNo) {
        this.id = id;
        this.name = name;
        this.accountNo = accountNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
