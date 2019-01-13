<%@page import="sec01_exam.MemberDto"%>
<%@page import="sec01_exam.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String findid = (String)session.getAttribute("id");
	MemberDao dao = MemberDao.getInstance();
	
	MemberDto dto = dao.getMember(findid);
	
	String id = dto.getId();
	String pw = dto.getPw();
	String name = dto.getName();
	String eMail = dto.geteMail();
	String rDate = dto.getrDate();
	String address = dto.getAddress();
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>

<script lang="JavaScript" src="members.js"></script>
</head>
<body>
	<form action="modifyOK.jsp" method="post" name="reg_frm">
		아이디 : <input type="text" name="id" value= <%=id %> size="20" readonly="readonly"> <br/>
		비밀번호 : <input type="password" name="pw" size="20"> <br/>
		비밀번호 확인 : <input type="password" name="pw_check" size="20"> <br/>
		이름 : <input type="text" name="name" value= <%=name %> size="20" readonly="readonly"> <br/>
		메일 : <input type="text" name="eMail" value= <%=eMail %> size="20"> <br/>
		주소 : <input type="text" name="address" value= <%=address %> size="50"> <br/>
	
		<input type="button" value="수정완료" onclick="infoConfirm()"> &nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소" onclick="javascript:window.location='main.jsp'">
		
	</form>
</body>
</html>