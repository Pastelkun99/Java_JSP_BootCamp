<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request 예제</title>
<style>
h1{
	text-align: center;
}
table{
	margin: auto;
	width: 400px;
	border: 1px solid red;
	background-color: aqua;
}
</style>
</head>
<body>
	<%
		String name, gender;
		String[] hobby;
		
		request.setCharacterEncoding("UTF-8");
		name = request.getParameter("name");
		gender = request.getParameter("gender");
		hobby = request.getParameterValues("hobby");
	
	%>


	<h1>Request 예제</h1>
	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=gender %></td>
		</tr>
		<tr>
			<td>취미</td>
			<td><%=Arrays.toString(hobby) %></td>
		</tr>
	</table>
</body>
</html>