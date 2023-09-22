<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Articles</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }
        th {
            background-color: #e0e0e0;
        }
        td {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #d9d9d9;
        }
        .action-btns a {
            margin-right: 10px;
            padding: 5px 10px;
            text-decoration: none;
            color: #595959;
            border: 1px solid #b3b3b3;
            border-radius: 5px;
        }
        .action-btns a:hover {
            background-color: #a6a6a6;
        }
        .add-btn {
            padding: 10px;
            background-color: #595959;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .add-btn:hover {
            background-color: #404040;
        }
    </style>
</head>
<body>
<h1>Articles</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Content</th>
        <th>Category</th>
        <th>Created</th>
        <th>Updated</th>
    </tr>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.author.name}</td>
            <td>${article.content}</td>
            <td>${article.category}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td class="action-btns">
                <a href="articles/edit/${article.id}">Edit</a>
                <a href="articles/delete/${article.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a class="add-btn" href="articles/add">Add New Article</a>
</body>
</html>
