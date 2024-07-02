<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Detail</title>
</head>
<body>
	<div>
		<h2>Post Detail</h2>
	</div>
	<div>
        <form action="/postdetail" method="post">
            <input type="hidden" id="no" name="no" value="${post.no}">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="${post.title}" required><br><br>
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="${post.id}" required><br><br>
            <label for="date">Date:</label>
            <input type="text" id="date" name="date" value="${post.date}" required><br><br>
            <div class="button-container">
                <button type="submit">Submit</button>
                <button type="button" onclick="window.location.href='/'">Cancel</button>
            </div>
        </form>
    </div>
</body>
</html>