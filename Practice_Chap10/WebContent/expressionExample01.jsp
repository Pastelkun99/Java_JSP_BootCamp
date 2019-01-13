<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int i = 10;
		String str = "신은혁";
		
		private int mul(int a, int b) {
			return a*b;
		}
	%>
	
	<!-- 표현식에서는 ;을 붙이지 않는다. -->
	<%= i %> <br/>
	<%= str %> <br/>
	<%= mul(50, 60) %> <br/>
</body>
</html>