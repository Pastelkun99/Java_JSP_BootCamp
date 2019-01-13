<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성인인증 완료</title>
</head>
<body>
	<% String age = request.getParameter("age"); %>
	나이 : <%=age %>
	<h2>성인이시군요. 소주를 살 수 있네요.</h2>
	<a href="requestExample.html" target="_self">처음으로 이동</a>	
</body>
</html>