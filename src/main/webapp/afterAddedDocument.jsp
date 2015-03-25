<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:choose>
    <c:when test="${not empty docId}">
        Successfully adde document to database. ID: <c:out value="${docId}"/>
    </c:when>
    <c:otherwise>
        Failed to add document to database.
    </c:otherwise>
</c:choose>

<br>
<br>

<form action="index.html" method="get">
    <input type="submit" VALUE="Back to index">
</form>

</body>
</html>
