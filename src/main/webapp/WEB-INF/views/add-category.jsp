<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }
        h1 {
            background-color: #e0e0e0;
            padding: 10px;
            border-radius: 5px;
        }
        form {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 5px;
            width: 50%;
            text-align: center;
        }
        input[type="text"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #595959;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #404040;
        }
        a {
            text-decoration: none;
            color: #595959;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<h1>Add Category</h1>
<form action="add" method="POST">
    Name: <input type="text" name="name"><br>
    <input type="submit" value="Add Category">
</form>
<br>
<a href="/categories">Back to List</a>
</body>
</html>