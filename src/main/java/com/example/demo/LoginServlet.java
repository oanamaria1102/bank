package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginServlet extends HttpServlet {

    public LoginServlet(){super();}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("usn");
        String password = req.getParameter("psw");
        int isAnaf = -1;
        String sqlPassword = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from accounts where username = '" + username + "'");
            if (resultSet.next()) {
                isAnaf = resultSet.getInt("isAnaf");
                sqlPassword = resultSet.getString("password");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        if (isAnaf == 0 && password.equals(sqlPassword)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("clientHome.jsp");
            requestDispatcher.forward(req, resp);
        }
        return;

    }
}
