<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="customer" class="sec02_exam.Customer" scope="page"></jsp:useBean>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java bean test</title>
</head>
<body>
	<jsp:setProperty property="*" name="customer"/>
	
	<h1>자바 빈 속성 값 출력</h1>
	이름 : <jsp:getProperty property="name" name="customer"/> <br/>
	주소 : <jsp:getProperty property="addr" name="customer"/> <br/>
	이메일 주소 : <jsp:getProperty property="email" name="customer"/><br/>
	생년월일 : <jsp:getProperty property="birthday" name="customer"/><br/>
	
	<%-- jsp:getproperty 태그가 아닌 <%=customer.getName() %>과 같이 사용해도 됩니다. --%>
</body>
</html>