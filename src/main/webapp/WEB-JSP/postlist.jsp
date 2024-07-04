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
        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .pagination a {
            margin: 0 5px;
            padding: 10px 20px;
            text-decoration: none;
            color: black;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .pagination a.active {
            background-color: #f2f2f2;
            font-weight: bold;
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
                <td><a href="/postdetail?no=${post.no}" style="text-decoration:none; color:black;">${post.title}</a></td>
                <td>${post.id}</td>
                <td>${post.date}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form action="/postadd" method="get">
        <button type="submit">등록</button>
    </form>

    <div class="pagination">
        <c:forEach begin="1" end="${totalPages}" var="i">
            <a href="/posts?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a>
        </c:forEach>
    </div>
</body>
</html>
