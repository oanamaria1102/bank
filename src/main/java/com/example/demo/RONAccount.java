package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RONAccount implements Account{
    private float ronAmount;
    private String accountNr;

    public RONAccount(){
        ronAmount = 0;
        accountNr = "RON" + (int) (Math.random() * 100000);
    }

    public RONAccount(float ronAmount, String accountNr) {
        this.ronAmount = ronAmount;
        this.accountNr = accountNr;
    }

    @Override
    public boolean deposit(float amount) {
        if(amount > 1000){
            ronAmount+=amount;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set soldRON=" + ronAmount + " where ronAccount = '" + accountNr + "'");
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
        if(ronAmount < amount)
            return false;
        else{
            ronAmount-=amount;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set soldRON=" + ronAmount + " where ronAccount = '" + accountNr + "'");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            return true;
        }
    }

    @Override
    public float checkSold() {
        return ronAmount;
    }

    @Override
    public float getAmount() {
        return ronAmount;
    }

    @Override
    public String getAccountNr() {
        return accountNr;
    }

}
