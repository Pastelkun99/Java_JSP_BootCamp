<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>include액션 테그테스트</h2>
	<jsp:include page="includeParam.jsp" flush="false">
		<jsp:param value="jsh" name="name" />
		<jsp:param value="30" name="age" />
	</jsp:include>
	<br>
	<h2>다시 include.jsp파일입니다.</h2>
</body>
</html>