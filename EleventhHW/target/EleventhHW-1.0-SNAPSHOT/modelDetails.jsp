<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 18.10.2023
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${model.getDescription()}</p>
<c:forEach var="url" items="${model.getImageUrls()}">
    <img src="${url}" alt="img">
</c:forEach>
</body>
</html>
