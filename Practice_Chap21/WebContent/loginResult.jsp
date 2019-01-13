<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name, id, pw, rDate;
		Date now = new Date();
		request.setCharacterEncoding("UTF-8");
		String sessionID = session.getId();
		// 앞선 강의에서도 설명했듯 session의 get값은 Object이므로 강제타입 변환을 한다.
		id = (String)session.getAttribute("id");
		pw = (String)session.getAttribute("pw");
		name = (String)session.getAttribute("name");
		rDate = (String)session.getAttribute("rDate");
		
		// 유니크한 세션값을 출력해본다.
		out.println("세션 아이디 : " + sessionID + "<br/>");
	%>
	
	<%=name %> 님 반갑습니다! <br/>
	접속 일시 : <%=now.toString() %> <br/>
	가입 일시 : <%out.println(rDate); %><br/>
	<a href="modify.jsp">회원정보 수정</a>
	<a href="logout.jsp">로그아웃 하기</a>
</body>
</html>