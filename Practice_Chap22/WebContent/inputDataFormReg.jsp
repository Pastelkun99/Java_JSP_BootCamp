<%@page import="sec01_exam.New_MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sec01_exam.New_MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뜨게함</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		New_MemberDTO dto = new New_MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPw(pw);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setGender(gender);
		
		New_MemberDAO dao = new New_MemberDAO();
		dao.memberInsert(dto);
		response.sendRedirect("memberselect.jsp");
	%>
</body>
</html>