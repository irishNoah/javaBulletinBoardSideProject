<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Detail</title>
<script>
    function handleSubmit() {
        console.log("User Clicked Submit Button!");
        
        alert(`수정됐습니다.`);
    }
    
    function handleDelete() {
        console.log("User Clicked Delete Button!");
        document.getElementById("method").value = "DELETE";
        document.getElementById("postForm").submit();
        
        alert(`삭제됐습니다.`);
    }
    
    function handleCancel() {
        console.log("User Clicked Cancel Button!");
        window.location.href = '/';
    }
</script>
</head>
<body>
	<div>
		<h2>Post Detail</h2>
	</div>
	<div>
        <form id="postForm" action="/postdetail" method="post">
            <input type="hidden" id="no" name="no" value="${post.no}">
            <input type="hidden" id="method" name="_method" value="POST">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="${post.title}" required><br><br>
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="${post.id}" required><br><br>
            <label for="date">Date:</label>
            <input type="text" id="date" name="date" value="${post.date}" required><br><br>
            <div class="button-container">
                <button type="submit" onclick="handleSubmit()">수정</button>
                <button type="button" onclick="handleDelete()">삭제</button>
                <button type="button" onclick="handleCancel()">이전</button>
            </div>
        </form>
    </div>
</body>
</html>