<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: КТ
  Date: 14.10.2023
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess number</title>
</head>
<body>
<%
    Random rnd = new Random();
    int number = rnd.nextInt(100);
%>
    <form action="GuessNumberServlet" method="POST">
        <input type="hidden" name="number" value="<%= number %>">
        <input type="hidden" name="left" value="0">
        <input type="hidden" name="right" value="100">
        <labe>The number is <%= number %></labe>
        <input type="submit" name="compare" value="Greater">
        <input type="submit" name="compare" value="Smaller">
        <input type="submit" name="compare" value="Equals">
    </form>
<a href="index.jsp">Go back</a>
</body>
</html>
