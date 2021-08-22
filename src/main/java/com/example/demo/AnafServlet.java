package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AnafServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("monitor") != null){
            try {
                String regCnp = req.getParameter("monitor");
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set isMonitored=1 where cnp='" + regCnp + "'");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (req.getParameter("unmonitor") != null){
            try {
                String regCnp = req.getParameter("unmonitor");
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set isMonitored=0 where cnp='" + regCnp + "'");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("anaf.jsp");
        requestDispatcher.forward(req, resp);
    }
}
