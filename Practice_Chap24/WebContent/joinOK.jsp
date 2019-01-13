<%@page import="sec01_exam.MemberDao"%>
<%@page import="sec01_exam.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String eMail = request.getParameter("eMail");
	String rDate = request.getParameter("rDate");
	String address = request.getParameter("address");
	
	MemberDto dto = new MemberDto();
	dto.setId(id);
	dto.setPw(pw);
	dto.setName(name);
	dto.seteMail(eMail);
	dto.setrDate(rDate);
	dto.setAddress(address);
%>

<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
</head>
<body>
	<h1><%=name %>님 환영합니다.</h1>
	<% 
		MemberDao dao = MemberDao.getInstance();
		dao.insertMember(dto);
	%>
	<input type="button" value="로그인 창으로" onclick="javascript:window.location='login.jsp'">
</body>
</html>