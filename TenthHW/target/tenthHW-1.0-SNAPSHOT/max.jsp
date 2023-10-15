<%--
  Created by IntelliJ IDEA.
  User: КТ
  Date: 15.10.2023
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Enter Three Numbers:</h1>
<form action="MaxServlet" method="post">
   <input type="text" name="num1"><br>
   <input type="text" name="num2"><br>
    <input type="text" name="num3"><br>
    <h2>Choose Operation:</h2>
    <input type="radio" name="operation" value="maximum" checked> Maximum
    <input type="radio" name="operation" value="minimum"> Minimum
    <input type="radio" name="operation" value="average"> Average

    <input type="submit" value="Calculate Maximum">
</form>
</body>
</html>
