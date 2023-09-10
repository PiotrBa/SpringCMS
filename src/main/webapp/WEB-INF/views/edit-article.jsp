<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Article</title>
</head>
<body>
<h1>Edit Article</h1>
<form action="../edit" method="POST">
    <input type="hidden" name="id" value="${article.id}">
    Title: <input type="text" name="title" value="${article.title}"><br>
    Author: <input type="text" name="author" value="${article.author}"><br>
    Content: <input type="text" name="content" value="${article.content}"><br>
    <input type="submit" value="Save">
</form>
<br>
<a href="../articles">Back to List</a>
</body>
</html>
