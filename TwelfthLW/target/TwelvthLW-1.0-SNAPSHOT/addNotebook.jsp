<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 19.10.2023
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="AddNotebookServlet">
    <div>
        <label>Enter manufacturer</label>
        <input type="text" name="manufacturer">
    </div>
    <div>
    <label>Enter notebook name</label>
    <input type="text" name="notebookName">
    </div>
    <div>
        <label>Enter number of pages</label>
        <input type="number" name="numberOfPages">
    </div>
    <div>
        <label>Is cover soft?</label>
        <select name="isCoverSoft">
            <option value="1">Yes</option>
            <option value="0">No</option>
        </select>
    </div>
    <div>
        <label>Enter page appearance</label>
        <select name="pageAppearanceId">
            <c:forEach items="${notebookAppearances}" var="appearance">
                <option value="${appearance.getId()}">${appearance.getAppearance()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Enter country</label>
        <select name="countryId">
            <c:forEach items="${countries}" var="country">
                <option value="${country.getId()}">${country.getCountryName()}</option>
            </c:forEach>
        </select>
    </div>
    <input type="submit" value="Send">
</form>
</body>
</html>
