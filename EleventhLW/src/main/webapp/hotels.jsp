<%--
  Created by IntelliJ IDEA.
  User: КТ
  Date: 16.10.2023
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<c:forEach items="${hotels}" var="hotel">
    <img style="width: 350px" src="${hotel.getImagePath()}">
    <li>${hotel}</li>
    <form action="HotelDetailsServlet" method="get">
        <input type="hidden" name="hotelName" value="${hotel.getName()}">
        <input type="submit" value="Get details">
    </form>
</c:forEach>
</ul>
</body>
</html>
