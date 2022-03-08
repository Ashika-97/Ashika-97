<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginPage" method="post">
<%session.invalidate(); %>
<p>you're successfully loggedout</p>
<a href="Login.jsp" >Login Again</a>
</form>
</body>
</html>