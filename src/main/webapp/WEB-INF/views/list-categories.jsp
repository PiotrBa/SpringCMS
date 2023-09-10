<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Categories</title>
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
<h1>Categories</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td class="action-btns">
                <a href="categories/edit/${category.id}">Edit</a>
                <a href="categories/delete/${category.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a class="add-btn" href="categories/add">Add New Category</a>
</body>
</html>
