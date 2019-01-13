<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.invalidate();
	// response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃 되었습니다. 감사합니다.</h1>
	<input type="button" value="로그인 창으로" onclick="javascript:window.location='login.jsp'">
</body>
</html>