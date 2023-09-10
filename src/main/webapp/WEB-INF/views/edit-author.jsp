<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
<h1>Edit Author</h1>
<form action="../edit" method="post">
  <input type="hidden" name="id" value="${author.id}">
  Fist name: <input type="text" name="firstName" value="${author.firstName}"><br>
  Last name: <input type="text" name="lastName" value="${author.lastName}"><br>
  <input type="submit" value="Save">
</form>
<br>
<a href="../authors">Back to list</a>
</body>
</html>
