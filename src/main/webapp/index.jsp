<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%
    String oana = "mumu";
%>
<a href="hello-servlet">Hello</a>
<a href="mumu.jsp?val=<%=oana%>"><%=oana%></a>
</body>
</html>