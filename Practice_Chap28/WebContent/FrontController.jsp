<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>확장자 패턴</title>
</head>
<body>
	<!-- 확장자 패턴(*.do)으로 각각 다른 메서드를 부르고 있다. -->
	<a href="insert.do">insert</a>
	<hr/>
	<a href="http://localhost:8181<%=request.getContextPath() %>/update.do">update</a>
	<hr/>
	<a href="select.do">select</a>
	<hr/>
	<a href="delete.do">delete</a>
	<hr/>
</body>
</html>