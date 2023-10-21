<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 20.10.2023
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="CreateCountryServlet">
    <div>
        <label>Enter country name</label>
        <input type="text" name="countryName">
    </div>
    <div>
        <label>Enter population</label>
        <input type="number" name="population">
    </div>
        <input type="submit" value="Send">
</form>
</body>
</html>
