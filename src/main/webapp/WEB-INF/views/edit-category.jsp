<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<h1>Edit Category</h1>
<form action="../edit" method="POST">
    <input type="hidden" name="id" value="${category.id}">
    Name: <input type="text" name="name" value="${category.name}"><br>
    Description: <input type="text" name="description" value="${category.description}"><br>
    <input type="submit" value="Save">
</form>
<br>
<a href="../categories">Back to List</a>
</body>
</html>
