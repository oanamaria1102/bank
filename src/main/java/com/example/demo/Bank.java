package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> clients;

    public Bank(ArrayList<Client> clients){
        this.clients = clients;
    }

    public void createClientBankAccount(String cnp, String password, String confirmPassword){
        if(password.equals(confirmPassword))
        {
            Client client = new Client(cnp, password, "RON", "EURO");
            clients.add(client);
        }
    }

    public static void closeAccount(String username){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank","root","root");
            Statement stmt = con.createStatement();
            stmt.execute("delete from accounts where username = '" + username + "'");
            stmt.execute("delete from client where cnp = '" + username + "'");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public void deleteClients(){

    }
}
