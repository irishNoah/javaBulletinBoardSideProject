<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Redirecting...</title>
</head>
<body>
    <%
        response.sendRedirect("WEB-JSP/postlist.jsp");
    %>
    <p>If you are not redirected automatically, follow this <a href="WEB-JSP/postlist.jsp">link</a>.</p>
</body>
</html>