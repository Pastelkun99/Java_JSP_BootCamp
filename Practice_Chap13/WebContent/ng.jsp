<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애새끼가 디질라고</title>
</head>
<body>
	<% String age = request.getParameter("age"); %>
	나이 : <%=age %>
	<h2>깝치지마라</h2>
	<a href="requestExample.html" target="_self">처음으로 이동</a>	
</body>
</html>