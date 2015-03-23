<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:choose>
    <c:when test="${not empty deletedId}">
        Successfully deleted document. ID: <c:out value="${deletedId}"/>
    </c:when>
    <c:otherwise>
        Failed to delete document from database.
    </c:otherwise>
</c:choose>

<br>
<br>

<form action="index.html" method="get">
    <input type="submit" VALUE="Back to index">
</form>

</body>
</html>
