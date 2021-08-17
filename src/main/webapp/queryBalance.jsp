<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: oanam
  Date: 8/16/2021
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style type = "text/css">
        body {
            background-color: white;
        }

        h1 {
            color : #FFD700;
        }

        h2 {
            color: black;
            font-size: 20px;
            margin-left: 80px;
            margin-top: 100px;
        }

        h3 {
            color: black;
            font-size: 20px;
            margin-left: 80px;
            margin-top: 10px;
        }

        #right{
            width: 380px;
            height: 250px;
            float: right;
        }

    </style>
    <title>REVO BANK</title>
</head>
<body>
<h1>Revo Bank</h1>
<img id = "right" src="res/bank.jpg"/>
<%
    String username = request.getParameter("usn");
    String euroAccount = "";
    String ronAccount = "";
    float soldEURO = 0f;
    float soldRON = 0f;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from client where cnp = '" + username + "'");
        if (resultSet.next()) {
            euroAccount = resultSet.getString("euroAccount");
            soldEURO = resultSet.getFloat("soldEURO");
            ronAccount = resultSet.getString("ronAccount");
            soldRON = resultSet.getFloat("soldRON");
        }
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }

%>
<h2><%=euroAccount%> : <%=soldEURO%></h2>
<h3><%=ronAccount%> : <%=soldRON%></h3>

</body>
</html>
