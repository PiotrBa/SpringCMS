<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Article</title>
</head>
<body>
<h1>Add Article</h1>
<form action="add" method="POST">
  Title: <input type="text" name="title"><br>
  Author: <input type="text" name="author"><br>
  Content: <input type="text" name="content"><br>
  <input type="submit" value="Add Article">
</form>
<br>
<a href="../articles">Back to List</a>
</body>
</html>
