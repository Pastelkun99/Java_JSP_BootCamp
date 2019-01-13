<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>param 페이지</h1>
<%
request.setCharacterEncoding("UTF-8");
String name, age;
name = request.getParameter("name");
age = request.getParameter("age");
%>
넘어온 이름 : <%=name %><br>
넘어온 나이 : <%=age %>
</body>
</html>