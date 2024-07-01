<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Post</title>
</head>
<body>
    <h2>Add New Post</h2>
    <form action="/" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br><br>
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br><br>
        <label for="date">Date:</label>
        <input type="text" id="date" name="date" placeholder="YYYYMMDD" required><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
