<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="member" class="sec01_exam.MemberInfo" scope="page"/>
    <jsp:setProperty property="name" name="member" value="신은혁"/>
    <jsp:setProperty property="id" name="member" value="perpear"/>
    <jsp:setProperty property="pw" name="member" value="12345"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL태그 (빈표기법) 사용</title>
</head>
<body>
	액션태그 사용<br/>
	이름 : <jsp:getProperty property="name" name="member"/> <br/>
	아이디 : <jsp:getProperty property="id" name="member"/> <br/>
	비밀번호 : <jsp:getProperty property="pw" name="member"/> <br/>
	<hr/>
	EL표현방법은 코드의 가독성과 아울러, 표기법이 간단해서 코드를 절약할 수 있다. <br/>
	이름 : ${member.name } <br/>
	아이디 : ${member.id } <br/>
	비밀번호 : ${member.pw } <br/>
</body>
</html>