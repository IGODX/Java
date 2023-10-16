<%--
  Created by IntelliJ IDEA.
  User: КТ
  Date: 16.10.2023
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Details</h3>
<ul>
    <c:forEach items="${hotelDetails.getAdditionalPhotos()}" var="image">
        <li>
            <img width="300px" src="image">
        </li>
    </c:forEach>
    <p>${hotelDetails.getDescription()}</p>
</ul>
</body>
</html>
