<%@page import="sec01_exam.MemberDto"%>
<%@page import="sec01_exam.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDao dao = MemberDao.getInstance();
	int checkNum = dao.userCheck(id, pw); 	//회원인지 아닌지 확인
	
	if(checkNum == -1) {
%>
	<script lang="javascript">
		alert("아이디가 존재하지 않습니다.");
		history.go(-1);	// 이전 페이지로
	</script>
<%
	}
	else if(checkNum == 0) {
%>
	<script lang="javascript">
		alert("비밀번호가 일치하지 않습니다.");
		history.go(-1);
	</script>
<%
	}
	else if(checkNum == 1) {
		MemberDto dto = dao.getMember(id);
		if(dto == null) {
%>
	<script lang="javascript">
		alert("존재하지 않는 회원입니다.");
		history.go(-1);
	</script>
<%
		}
		else {
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			// ValidMem속성에 Yes의 값을 줌으로써 로그인 여부를 알 수 있다.
			session.setAttribute("ValidMem", "yes"); // 로그인 되었다.
			response.sendRedirect("main.jsp");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>