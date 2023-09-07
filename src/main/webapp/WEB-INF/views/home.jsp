<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Latest articles</h1>

<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Date added</th>
        <th>Contents</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.content}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
