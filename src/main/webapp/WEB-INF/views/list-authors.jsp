<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Authors</title>
</head>
<body>
<h1>Authors</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Last name</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <a href="authors/edit/${author.id}">Edit</a> |
                <a href="authors/delete/${author.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="add">Add New Author</a>
</body>
</html>
