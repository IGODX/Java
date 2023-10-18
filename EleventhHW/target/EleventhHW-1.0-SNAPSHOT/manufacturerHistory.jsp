<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 18.10.2023
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Manufacturer History</title>
</head>
<body>
<h1>Manufacturer History</h1>
<p>${manufacturerHistory.getText()}</p>
<c:forEach var="item" items="${manufacturerHistory.getUrls()}">
    <a href="${item}">${item}</a>
</c:forEach>
</body>
</html>
