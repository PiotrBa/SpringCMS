<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 07/09/2023
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<h1>Edit Category</h1>
<form action="../edit" method="post">
  <input type="hidden" name="id" value="${category.id}">
  Name: <input type="text" name="name" value="${category.name}"><br>
  Description: <input type="text" name="description" value="${category.description}"><br>
  <input type="submit" value="Save">
</form>
<br>
<a href="..categories">Back to list</a>
</body>
</html>
