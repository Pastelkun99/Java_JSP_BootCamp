<%@page import="sec01_exam.MemberDto"%>
<%@page import="sec01_exam.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
 
 <%
 	
 	MemberDao dao = MemberDao.getInstance();
 	int check = dao.updateMember(dto);
 	if(check != 1) {
 %>
 	<script lang="javascript">
		alert("아이디는 수정할 수 없습니다!");
		history.go(-1);
	</script>
 <%		
 	}
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=name %>님의 정보 수정이 완료되었습니다. 다시 로그인 해주십시오.</h1>
	<% session.invalidate(); %>
	<input type="button" value="다시 로그인 창으로" onclick="javascript:window.location='login.jsp'">
	
</body>
</html>