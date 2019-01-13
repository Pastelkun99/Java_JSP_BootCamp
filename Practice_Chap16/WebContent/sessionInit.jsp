<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 스크립트릿으로 내부객체인 session객체를 이용하여 값을 설정한다. 
	현재 이 jsp파일이 서버에 요청이 들어가면 JSP컨테이너가 서블릿으로 변환되면서 session객체가 자동 생성되면서 컴파일 된다. -->
	<%
		//session은 내장 객체라서 바로 사용 가능하다. 속성 각각 지정
		session.setAttribute("mySessionName", "mySessionData");
		session.setAttribute("jsh", 12345);
	%>
	<a href="sessionGet.jsp">세션값 확인</a>
</body>
</html>