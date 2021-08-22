package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class ClientHomeServlet extends HttpServlet {
    public ClientHomeServlet() { super(); }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Float amountEuroAdded = (req.getParameter("adde") != null) ? Float.parseFloat(req.getParameter("adde")) : null;
        Float amountRonAdded = (req.getParameter("addr") != null) ? Float.parseFloat(req.getParameter("addr")) : null;
        Float amountEuroWithdrawn = (req.getParameter("we") != null) ? Float.parseFloat(req.getParameter("we")) : null;
        Float amountRonWithdrawn = (req.getParameter("wr") != null) ? Float.parseFloat(req.getParameter("wr")) : null;
        String cnp = req.getParameter("usn");
        String password = "";
        String euroAccount = "";
        String ronAccount = "";
        float soldEURO = 0f;
        float soldRON = 0f;
        int isMonitored = -1;
        Client client = null;

        if (req.getParameter("close") != null) {
            Bank.closeAccount(req.getParameter("usn"));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from client where cnp='" + cnp + "'");
            if(resultSet.next()){
                euroAccount = resultSet.getString("euroAccount");
                soldEURO = resultSet.getFloat("soldEURO");
                ronAccount = resultSet.getString("ronAccount");
                soldRON = resultSet.getFloat("soldRON");
                client = new Client(cnp, password, ronAccount, euroAccount, soldRON, soldEURO);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        if (amountEuroAdded != null) {
            if(client != null){
                client.getEuroAccount().deposit(amountEuroAdded);
            }
        }

        if (amountRonAdded != null) {
            if(client != null){
                client.getRonAccount().deposit(amountRonAdded);
            }
        }

        if (amountRonWithdrawn != null) {
            if(client != null){
                client.getRonAccount().withdrawal(amountRonWithdrawn);
            }
        }

        if (amountEuroWithdrawn != null) {
            if(client != null){
                client.getEuroAccount().withdrawal(amountEuroWithdrawn);
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("clientHome.jsp");
        requestDispatcher.forward(req, resp);
    }
}
