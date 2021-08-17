package com.example.demo;

public interface Account {
    boolean deposit(float amount);
    boolean withdrawal(float amount);
    float checkSold();
    String getAccountNr();
    float getAmount();
}
