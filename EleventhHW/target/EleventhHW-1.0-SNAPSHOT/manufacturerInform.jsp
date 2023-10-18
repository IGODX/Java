<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 18.10.2023
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${manufacturer.name}</title>
</head>
<body>
<h1>${manufacturer.name}</h1>
<small>${manufacturer.country}</small>
<img src="${manufacturer.logoUrl}" alt="logo">
<p>Employees count : ${manufacturer.employeeCount}</p>
<p>About : ${manufacturer.about}</p>
</body>
</html>
