<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 스크립트릿으로 요청객체인 request객체의 일부 메서드를 확인해본다.
	request와 response객체는 내부객체로써 JSP파일이 요청되고
	jsp컨테이너에 의해 서블릿으로 변환될 때, 톰캣서버가 알아서 자동 생성해준다고 했다. -->
	
	<%
		//out 역시 내부객체이다.
		out.println("서버이름 : " + request.getServerName()+"<br/>");
		out.println("포트 번호 : " + request.getServerPort()+"<br/>");
		
		// 브라우저로 직접 접속하였으므로 Get 방식이다.
		out.println("요청방식 : " + request.getMethod()+"<br/>");
		out.println("프로토콜 : " + request.getProtocol()+"<br/>");
		
		// 컨텍스트패스는 앞선 강의에서도 설명했지만, 웹어플리케이션을 구분짓는 잣대가 된다.
		// 즉, 프로젝트 명이다.
		out.println("Context path : " + request.getContextPath()+"<br/>");
		out.println("URL : " + request.getRequestURL()+"<br/>");
		
		// URI는 도메인 주소(http://localhost:8181)을 제외한 나머지 값들을 의미한다.
		out.println("URI : " + request.getRequestURI() + "<br/>");
	%>
</body>
</html>