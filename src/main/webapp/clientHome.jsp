<%@ page import="com.example.demo.Bank" %><%--
  Created by IntelliJ IDEA.
  User: oanam
  Date: 8/16/2021
  Time: 10:15 PM
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
      color: #FFD700;
      text-align: left;
      margin: 0;
    }

    h2 {
      font-family: verdana;
      font-size: 35px;
      margin-left: 100px;
      margin-top: 60px;
    }

    h3 {
      font-family: verdana;
      font-size: 35px;
      margin-left: 200px;
      margin-top:-20px;
    }

    mark{
      background-color: #FFD700;
    }

    #right{
      width: 380px;
      height: 250px;
      float: right;
    }

    .clientContainer {
      text-align: center;
      margin: 10px 0 6px 0;
      margin-top: 100px;
    }

  </style>
  <title>REVO BANK</title>
</head>
<body>
<h1>Revo Bank</h1>
<img id = "right" src="res/bank.jpg"/>
<h2><mark>Welcome to</mark></h2>
<h3><mark>Revo Bank!</mark></h3>
<%
  String username = request.getParameter("usn");

%>
<div class="clientContainer">
  <h4><a href="queryBalance.jsp?usn=<%=username%>">Query balance.</a></h4>
  <form action="home" method="post">
    <label for="adde">Add money to EURO account (minimum amount accepted is 1000EURO):</label><br>
    <input type="hidden" name="usn" value="<%=username%>">
    <input type="text" id="adde" name="adde"><br>
    <input type="submit" value="Add EURO">
  </form>
  <form action="home" method="post">
    <label for="addr">Add money to RON account (minimum amount accepted is 1000RON):</label><br>
    <input type="hidden" name="usn" value="<%=username%>">
    <input type="text" id="addr" name="addr"><br>
    <input type="submit" value="Add RON">
  </form>
  <form action="home" method="post">
    <label for="we">Withdraw money from the EURO account:</label><br>
    <input type="hidden" name="usn" value="<%=username%>">
    <input type="text" id="we" name="we"><br>
    <input type="submit" value="Withdraw EURO">
  </form>
  <form action="home" method="post">
    <label for="wr">Withdraw money from the RON account:</label><br>
    <input type="hidden" name="usn" value="<%=username%>">
    <input type="text" id="wr" name="wr"><br>
    <input type="submit" value="Withdraw RON">
  </form>
  <h4>
    <form action="home" method="post">
      <input type="hidden" name="usn" value="<%=username%>">
      <input type="submit" name="close" value="Close account">
    </form>
  </h4>
</div>
</body>
</html>