<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정 성공</title>
</head>
<body>
	<% String name = (String)session.getAttribute("name");%>
	<h1><%=name %>님의 회원 정보가 수정되었습니다. 다시 로그인 하십시오.</h1>
	<br/><br/><br/>
	<a href="login.jsp">다시 로그인 창으로</a>
</body>
</html>