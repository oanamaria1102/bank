package com.example.demo;

public class Client {
    private String cnp;
    private String password;
    private Account ronAccount;
    private Account euroAccount;

    public Client(String cnp, String password, String ronAmount, String euroAmount){
        this.cnp = cnp;
        this.password = password;
        AccountFactory accountFactory= new AccountFactory();
        ronAccount = accountFactory.getType(ronAmount);
        euroAccount = accountFactory.getType(euroAmount);
    }

    public Client(){}

    public Account getRonAccount() {
        return ronAccount;
    }

    public void setRonAccount(Account ronAccount) {
        this.ronAccount = ronAccount;
    }

    public Account getEuroAccount() {
        return euroAccount;
    }

    public void setEuroAccount(Account euroAccount) {
        this.euroAccount = euroAccount;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
