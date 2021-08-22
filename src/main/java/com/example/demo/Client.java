package com.example.demo;

public class Client {
    private String cnp;
    private String password;
    private Account ronAccount;
    private Account euroAccount;

    public Client(String cnp, String password, String accountType1, String accountType2){
        this.cnp = cnp;
        this.password = password;
        AccountFactory accountFactory= new AccountFactory();
        ronAccount = accountFactory.getType(accountType1);
        euroAccount = accountFactory.getType(accountType2);
    }

    public Client(String cnp, String password, String ronAccountNr, String euroAccountNr, float soldRON, float soldEURO){
        this.cnp = cnp;
        this.password = password;
        this.ronAccount = new RONAccount(soldRON, ronAccountNr);
        this.euroAccount = new EuroAccount(soldEURO, euroAccountNr);
    }

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
