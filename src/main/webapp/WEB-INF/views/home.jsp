<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Ostatnie artykuły</h1>

<table>
    <thead>
    <tr>
        <th>Tytuł</th>
        <th>Data dodania</th>
        <th>Zawartość</th>
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
