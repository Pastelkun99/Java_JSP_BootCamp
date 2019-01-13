<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// session의 값이 ValidMem속성이 null이라면, 경고창을 띄우고
	if(session.getAttribute("ValidMem") == null) {
%>
	<script>
		alert("세션이 끊겼습니다. 다시 로그인 해주세요!");
	</script>
	<!-- 다시 로그인 페이지로 돌려보낸다. -->
	<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
	// session.getAttribute() 반환타입은 Object이다. 따라서 캐스팅함.
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 인증</title>
</head>
<body>
	<!-- 로그인한 사람의 이름을 출력함 -->
	<h1><%=name %>님 안녕하세요!</h1> <br/>
	<form action="logout.jsp" method="post">
		<input type="submit" value="로그아웃"> &nbsp;&nbsp;&nbsp;
		<input type="button" value="정보수정" onclick="javascript:window.location='modify.jsp'">
	</form>
</body>
</html>