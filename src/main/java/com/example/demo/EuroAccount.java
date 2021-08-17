package com.example.demo;

public class EuroAccount implements Account{
    private float euroAmount;
    private String accountNr;

    public EuroAccount(){
        euroAmount = 0;
        accountNr = "EUR" + (int) (Math.random() * 100000);
    }

    @Override
    public boolean deposit(float amount) {
        if(amount > 1000){
            euroAmount+=amount;
        }
        return false;
    }

    @Override
    public boolean withdrawal(float amount){
        if(euroAmount < amount)
            return false;
        else{
            euroAmount-=amount;
            return true;
        }
    }

    @Override
    public float checkSold() {
        return euroAmount;
    }

    @Override
    public float getAmount() {
        return euroAmount;
    }

    @Override
    public String getAccountNr() {
        return accountNr;
    }

}