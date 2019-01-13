<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- main.jsp를 아직 만들지 않았다. 따라서 링크를 클릭하면 404에러가 발생할 것이다.
	그렇다면 error404.jsp로 이동할것이다. 이동하는 이유는 이 프로젝트의 web.xml에 그렇게 설정해두었기 때문이다. -->
	
	<!-- 페이지를 찾지 못하는 404에러의 경우, 이동하려는 대상 페이지가 존재하지 않으므로 exception객체를 참조할 수 없습니다.
	따라서 404에러의 경우 exception객체를 사용하지 말자 -->
	<a href="main.jsp">메인으로 이동</a>
</body>
</html>