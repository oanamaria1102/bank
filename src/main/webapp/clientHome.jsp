<%--
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
<img id = "right" src="src/bank.jpg"/>
<h2><mark>Welcome to</mark></h2>
<h3><mark>Revo Bank!</mark></h3>
<div class="clientContainer">
  <h4><a href="queryBalance.jsp">Query balance.</a></h4>
  <h4><a href="/Users/oanam/Desktop/BankDesign/register.html">Add money to EURO account.</a></h4>
  <h4><a href="/Users/oanam/Desktop/BankDesign/register.html">Add money to RON account.</a></h4>
  <h4><a href="/Users/oanam/Desktop/BankDesign/register.html">Withdraw money from the EURO account.</a></h4>
  <h4><a href="/Users/oanam/Desktop/BankDesign/register.html">Withdraw money from the RON account.</a></h4>
  <h4><a href="/Users/oanam/Desktop/BankDesign/register.html">Close account.</a></h4>
</div>
</body>
</html>
