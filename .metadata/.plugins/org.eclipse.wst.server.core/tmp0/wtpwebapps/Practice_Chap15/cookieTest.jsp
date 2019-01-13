<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키의 값들이 삭제되었는지 확인하는 cookieTest.jsp페이지. 이 페이지도 서버에서 실행됨.</h1>
<%
//앞선 cookieDel.jsp에서 쿠키의 유효기간을 0으로 설정한 쿠키가 리턴될 것.
 Cookie[] cookies = request.getCookies();
//확인해 보면 JSESSIONID... 이런게 뜨는데 이건 기본적으로 서버에서 생성해주는 부분이니 그냥 무시하도록하자(항상 출력됨)
if(cookies != null){
	for(int i=0; i<cookies.length; i++){
		out.println("현재 남아있는 쿠키 이름 : "+cookies[i].getName());
		out.println("현재 남아있는 쿠키 값 : "+cookies[i].getValue());
	}
}
//여기서 꼭 기억할 것은, 쿠키를 생성하고 response객체에 탑재를 한다.
//아울러 그 쿠키의 변경이 일어나면 반드시 response객체에 또 탑재를 해야한다는 것이다.



%>
</body>
</html>