<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 현재 이 페이지에서 예외가 발생하면 페이지 지시자를 이용하여 errorPage.jsp페이지로 이동하라고 명시하고 있다. -->
    <%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // 모든 수는 0으로 나눌 수 없기 때문에 예외가 발생한다.
	   // ArithmeticException예외이다.
	   // int i = 40/0;
	   
	   // 아래에서는 NumberFormat예외가 발생한다.
	   int value = Integer.parseInt("100a");
	%>
</body>
</html>