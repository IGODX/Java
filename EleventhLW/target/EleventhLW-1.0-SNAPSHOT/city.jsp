<%--
  Created by IntelliJ IDEA.
  User: КТ
  Date: 16.10.2023
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${city.name}</title>
</head>
<body>
<h1>${city.name}, ${city.country}</h1>
<img style="width: 300px; height: 300px" src="${city.imagePath}" alt="Coat of arms">
<p>Population : ${city.population}</p>
<p>${city.description}</p>
</body>
</html>
