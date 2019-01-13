<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200);
	response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500 error</title>
</head>
<body>
	<br/>
	<h1>500에러입니다. 연산부분을 확인하세요.</h1>
	<%-- <%=exception.getMessage() %> --%>
</body>
</html>