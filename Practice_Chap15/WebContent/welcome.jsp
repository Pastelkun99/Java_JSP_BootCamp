<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 되었습니다.</h1>
	<script type="text/javascript">
		alert("로그인 성공");
	</script>
	<%
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			String id = cookies[i].getValue();

			if (id.equals("jsh")) {
				out.println(id + "님 반갑");
			}
		}
	%>
	<h1>환영</h1>
	<a href="logOut.jsp">로그아웃</a>
</body>
</html>