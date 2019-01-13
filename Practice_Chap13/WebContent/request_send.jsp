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
	String age = request.getParameter("age");
	String url = "";
	int agenum = Integer.parseInt(age);
	
	if(agenum >= 20) {
		url = "pass.jsp";
		System.out.println("request_send.jsp 호출 나이는 : " + agenum);
		response.sendRedirect(url + "?age=" + agenum);
	}
	else if(agenum > 0 && agenum < 20) {
		url = "ng.jsp";
		System.out.println("request_send.jsp 호출 나이는 : " + agenum);
		response.sendRedirect(url + "?age=" + agenum);
	}
%>
</body>
</html>