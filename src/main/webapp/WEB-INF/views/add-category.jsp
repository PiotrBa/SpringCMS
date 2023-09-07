<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 07/09/2023
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<h1>Add Category</h1>
<form action="add" method="post">
  Name: <input type="text" name="name"><br>
  Description: <input type="text" name="description"><br>
    <input type="submit" value="Add Category">
</form>
<br>
<a href="../categories">Back to list</a>
</body>
</html>
