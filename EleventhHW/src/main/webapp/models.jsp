<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 18.10.2023
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Models</title>
</head>
<body>
<c:forEach items="${laptops}" var="laptop">
    <h3>${laptop.getDescription()}</h3>
        <a href="ModelDetailsServlet?name=${laptop.getDescription()}">
    <img src="${laptop.getImageUrl()}" alt="image">
    </a>
</c:forEach>
</body>
</html>
