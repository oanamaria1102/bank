<%@ page import="com.example.demo.Client" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: oanam
  Date: 8/18/2021
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Anaf</title>
</head>
<body>
    <%
        ArrayList<String> cnpArrayNotMonitored = new ArrayList<>();
        ArrayList<String> cnpArrayMonitored = new ArrayList<>();
        ResultSet resultSet1 = null ;
        ResultSet resultSet2 = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "root", "root");
            Statement stmt = con.createStatement();
            resultSet1 = stmt.executeQuery("select * from client where isMonitored != 1");
            while (resultSet1.next()){
                cnpArrayNotMonitored.add(resultSet1.getString("cnp"));
            }
            resultSet2 = stmt.executeQuery("select * from client where isMonitored != 0");
            while (resultSet2.next()){
                cnpArrayMonitored.add(resultSet2.getString("cnp"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    %>
    <h3>Accounts not monitored</h3>
    <ul>
        <%
            for (String item : cnpArrayNotMonitored){
        %>
            <li><%=item%></li>
        <%
            }
        %>
    </ul>

    <form action="anaf" method="post">
        <label for="monitor">Add account to monitor:</label><br>
        <input type="text" id="monitor" name="monitor"><br>
        <input type="submit" value="Submit">
    </form>

    <h3>Accounts monitored</h3>
    <ul>
        <%
            for (String item : cnpArrayMonitored){
        %>
        <li><%=item%></li>
        <%
            }
        %>
    </ul>

    <form action="anaf" method="post">
        <label for="monitor">Remove monitored account:</label><br>
        <input type="text" id="unmonitor" name="unmonitor"><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
