<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<html>
<head>
<%-- <% %> <- 스크립트릿이라고 한다. jsp파일에 자바코드를 삽입할때 반드시 표기해야한다. --%>
<%
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR_OF_DAY);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);
%>
<meta charset="UTF-8">
<title>현재시각</title>
</head>
<body>
	<%-- <%= %> 은 스크립트릿의 일종으로 표현식(expression)이다. 
	값을 나타내는 것이지만 ;을 나타내는 것이 아님에 주의하자 --%>
	현재 시간은 <%=hour %>시 <%=minute %>분 <%=second %>초 입니다.
</body>
</html>