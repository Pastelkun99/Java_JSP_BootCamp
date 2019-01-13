<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form태그를 이용하여 id와 pw를 입력받고 post방식으로 loginOk.jsp페이지로 이동합니다 -->
	<h1>로그인 페이지</h1>
	<form action="loginOk.jsp" method="post">
		아이디 : <input type="text" name="id" size="10"><br> 
		비밀번호 :<input type="password" name="pw" size="10"><br> 
		<input type="submit" value="로그인"> <input type="reset" value="초기화">
	</form>
</body>
</html>