<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키의 값들을 삭제하는 cookieDel.jsp페이지. 이 페이지도 서버에서 실행됨.</h1>
	<%
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			//쿠키의 이름을 얻는다.
			String str = cookies[i].getName();
			//만약 쿠키의 이름이 jsh라면 
			if (str.equals("jsh")) {
				out.println("cookies[" + i + "] name :" + cookies[i].getName());
				//유효기간을 0초로 설정하면 삭제 효과를 지니다.
				cookies[i].setMaxAge(0);
				//또한 위의 변경된 속성의 쿠키를 response객체에 담는다.
				//물론 기존의 같은 쿠키이다.
				response.addCookie(cookies[i]);
			}
		}
	%>
	<br>
	<br>
	<a href="cookieTest.jsp">쿠키 확인</a>
</body>
</html>