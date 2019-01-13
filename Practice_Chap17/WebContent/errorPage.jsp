<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 페이지 지시자를 이용해서 isErrorPage속성을 true로 설정해준다.
    이와 같이 설정해야만 exception객체를 참조할 수 있으며, 이 페이지가 실행된다.
    원래 기본값은 false이다. -->
<%@ page isErrorPage="true" %>
<!-- 정상적인 페이지라고 명시하기 위해 response객체의 setStatus메서드를 이용해서 200이란 값을 지정하고 있다.
그렇지 않으면 웹컨테이너에서 보통 500으로 설정하려고 해서 예외 페이지로 이동되는것이 아닌 다른 이상한 페이지로 이동한다.
현재 이 페이지는 예외가 발생한 페이지가 아니다. 단지, 다른페이지에서 예외가 발생하여 이 페이지로 이동하게 하면 작동하는
정상적인 페이지인 것이다. 버전이 업그레이드 되면서 500으로 설정해주지 않는 경우도 발생한다. -->
<% 
	response.setStatus(200);
    response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	에러 발생 <br/>
	<!-- 표현식으로 에러가 발생한 내용을 보여준다. -->
	<%=exception.getMessage() %>
</body>
</html>