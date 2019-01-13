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

Cookie[] cookies = request.getCookies();

if(cookies != null){
	for(int i=0; i<cookies.length; i++){
		String id = cookies[i].getValue();
			if (id.equals("jsh")) {
				cookies[i].setMaxAge(0); //쿠키 삭제
				//또한 위의 변경된 속성의 쿠키를 response객체에 담는다.
				//물론 기존의 같은 쿠키이다.
				response.addCookie(cookies[i]);
				out.println(id + "님이 로그아웃함");
			}
	}
}
 %>
	<br>
	<br>
	<a href="cookieTest.jsp">쿠키확인</a>
</body>
</html>