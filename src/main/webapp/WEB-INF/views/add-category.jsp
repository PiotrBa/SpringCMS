<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<h1>Add Category</h1>
<form action="add" method="POST">
    Name: <input type="text" name="name"><br>
    Description: <input type="text" name="description"><br>
    <input type="submit" value="Add Category">
</form>
<br>
<a href="../categories">Back to List</a>
</body>
</html>