package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EuroAccount implements Account{
    private float euroAmount;
    private String accountNr;

    public EuroAccount(){
        euroAmount = 0;
        accountNr = "EUR" + (int) (Math.random() * 100000);
    }

    public EuroAccount(float euroAmount, String accountNr) {
        this.euroAmount = euroAmount;
        this.accountNr = accountNr;
    }

    @Override
    public boolean deposit(float amount) {
        if(amount > 1000){
            euroAmount+=amount;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set soldEURO=" + euroAmount + " where euroAccount = '" + accountNr + "'");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean withdrawal(float amount){
        if(euroAmount < amount)
            return false;
        else{
            euroAmount-=amount;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set soldEURO=" + euroAmount + " where euroAccount = '" + accountNr + "'");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

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
