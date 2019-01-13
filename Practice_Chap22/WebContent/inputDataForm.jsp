<%@page import="sec01_exam.New_MemberDTO"%>
<%@page import="sec01_exam.New_MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록해보자</title>
</head>
<body>
	<form action="inputDataFormReg.jsp" method="post">
		이름 : <input type="text" name="name" size="20"> <br/>
		아이디 : <input type="text" name="id" size="20"> <br/>
		비밀번호 : <input type="password" name="pw" size="20"> <br/>
		전화번호 : <input type="text" name="phone1" size="5"> &nbsp;-&nbsp; <input type="text" name="phone2" size="5"> &nbsp;-&nbsp; <input type="text" name="phone3" size="5"> <br/>
		성별 : <input type="text" name="gender" size="20"> <br/>
		<input type="submit" value="DB등록">
		<input type="reset" value="초기화">
	</form>
	<%-- <%
		String name = request.getParameter("name");
		if(name != null) {
			
		}
	%> --%>
</body>
</html>