<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 지금은 JSP파일에서 데이터를 받는 형태이다. -->
	<!-- 스크립 중 선언부 -->
	<%!
		String name, id, pw, major, job;
		String[] hobbys;
		
		// 아래와 같이 선언해도 상관없다. 어차피 JSP 컨테이너가 생성해준 request객체가 메모리에 할당해준다.
		// 서블릿으로 변환될때
		// String[] hobbys = new String[10];
	%>
		<!-- 스크립트릿을 이용해서 request객체의 값을 가져오는 방법 -->
	<%
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		major = request.getParameter("major");
		job = request.getParameter("job");
		
		// 취미는 다중선택이 가능하므로 배열 형태로 받고 있다.
		hobbys = request.getParameterValues("hobby");
		
	%>
	
	<!-- 표현식(expression)을 통해 값을 출력함 -->
	전송받은 이름 : <%=name %> <br/>
	전송받은 아이디 : <%=id %> <br/>
	전송받은 비밀번호 : <%=pw %> <br/>
	전송받은 전공 : <%=major %> <br/>
	전송받은 직업 : <%=job %> <br/>
	<!-- for 문을 이용해서 출력해도 상관없습니다. -->
	전송받은 취미 : <%=Arrays.toString(hobbys) %>
	
	
</body>
</html>