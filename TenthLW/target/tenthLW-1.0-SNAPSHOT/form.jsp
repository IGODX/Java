<%--
  Created by IntelliJ IDEA.
  User: КТ
  Date: 15.10.2023
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="FormServlet" method="POST">
    <label for="fullName">Full name:</label>
    <input type="text" name="fullName" id="fullName" required><br>

    <label for="phone">Telephone:</label>
    <input type="text" name="phone" id="phone" required><br>

    <label for="email">Email:</label>
    <input type="email" name="email" id="email" required><br>

    <label for="age">Age:</label>
    <input type="number" name="age" id="age" required><br>

    <label>Gender:</label>
    <input type="radio" name="gender" value="Male" id="male">Male
    <input type="radio" name="gender" value="Female" id="female">Female

    <label for="subscribe">Do you want to make subscription?</label>
    <input type="checkbox" name="subscribe" id="subscribe"><br>

    <input type="submit" value="Send">
</form>
</body>
</html>
