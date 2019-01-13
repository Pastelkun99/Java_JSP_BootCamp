<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커넥션풀 테스트</title>
</head>
<body>
	<%
		// DBCP를 사용하기 위해 context.xml에 내용을 추가했음
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/dbtool");
		ds.getConnection();
		System.out.println("드라이버 성공!");
	%>
</body>
</html>