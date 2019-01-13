<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward.jsp 페이지 입니다.</h1>
	<%
		System.out.println("forwardParam으로 넘기기전 forward페이지 입니다.");
	%>
	<!-- forward액션태그를 이용해서 페이지 이동을 하고 있다. 안에 파라메터를 전달하고자 jsp:param액션태그를 사용했다. 이울러 페이지 이동을 하면 내부객체인 request객체는
서로 공유하기 때문에 forwardParam.jsp페이지에서 넘긴 이 값을 받아서 사용할 수 있다. 도 강조하지만 URL은 변하지 아니한다. -->
	<jsp:forward page="forwardParam.jsp">
		<jsp:param value="admin" name="id" />
		<jsp:param value="1234" name="pw" />
	</jsp:forward>
</body>
</html>