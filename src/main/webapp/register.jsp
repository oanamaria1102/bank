<%--
  Created by IntelliJ IDEA.
  User: oanam
  Date: 8/12/2021
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        form {border: 3px solid #f1f1f1;}

        input[type=text], input[type=password], input[type=confpassword] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        h2 {
            color: #FFD700;
            text-align: left;
            margin: 0;
        }

        button {
            background-color: black;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #FFD700;
        }

        .imgcontainer {
            text-align: center;
            margin: 10px 0 6px 0;
        }

        img.avatar {
            width: 15%;
            border-radius: 50%;
        }

        .container {
            padding: 16px;
        }
    </style>
</head>
<body>

<h2>Revo Bank</h2>

<form action="register">
    <div class="imgcontainer">
        <img src="res/img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label><b>CNP</b></label>
        <input type="text" placeholder="Enter CNP" name="cnp" required>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <label><b>Confirm Password</b></label>
        <input type="password" placeholder="Confirm Password" name="cpsw" required>

        <button type="submit" onclick="window.location.href='login.jsp'">Create Account</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn" onclick="window.location.href='index.jsp'">Cancel</button>
    </div>
</form>

</body>
</html>
