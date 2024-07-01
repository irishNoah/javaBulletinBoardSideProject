<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bulletin Board</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Bulletin Board</h2>
    <table>
        <tr>
            <th>NO</th>
            <th>TITLE</th>
            <th>ID</th>
            <th>Date</th>
        </tr>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>${post.no}</td>
                <td>${post.title}</td>
                <td>${post.id}</td>
                <td>${post.date}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form action="/postadd" method="get">
        <button type="submit">Register</button>
    </form>
</body>
</html>
