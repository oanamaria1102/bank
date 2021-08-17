package com.example.demo;

public class AccountFactory {
    public Account getType(String accountType){
        if(accountType == null){
            return null;
        }
        if(accountType.equalsIgnoreCase("RON")){
            return new RONAccount();

        } else if(accountType.equalsIgnoreCase("EURO")){
            return new EuroAccount();

        }

        return null;
    }
}
