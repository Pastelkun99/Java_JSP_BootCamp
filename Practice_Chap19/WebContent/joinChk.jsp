<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <jsp:useBean id="member" class="sec03_exam.Member" scope="page"></jsp:useBean>
   <% request.setCharacterEncoding("UTF-8"); %>
   <jsp:setProperty property="*" name="member"/>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력 정보 확인 페이지</title>
</head>
<body>
	
	<b>아이디 :</b> 		<jsp:getProperty property="id" name="member"/> <br/>
	<b>비밀번호 :</b> 		<jsp:getProperty property="pass" name="member"/> <br/>
	<b>이름 :</b> 			<jsp:getProperty property="name" name="member"/> <br/>
	<b>성별 :</b> 			<jsp:getProperty property="sex" name="member"/> <br/>
	<b>나이 :</b> 			<jsp:getProperty property="age" name="member"/> <br/>
	<b>이메일 주소 :</b> 	<jsp:getProperty property="email" name="member"/> <br/>
	
</body>
</html>