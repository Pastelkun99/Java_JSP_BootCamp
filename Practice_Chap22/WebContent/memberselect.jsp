<%@page import="sec01_exam.New_MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sec01_exam.New_MemberDAO"%>
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
		// MemberDAO를 생성하고 memberselect()를 호출하고 있다.
		New_MemberDAO memberDao = new New_MemberDAO();
		ArrayList<New_MemberDTO> dtos = memberDao.memberselect();
		request.setCharacterEncoding("UTF-8");
		
		for(int i = 0; i<dtos.size(); i++) {
			// ArrayList<MemberDTO>에서 추가된 MemberDTO객체를 하나씩 꺼내고 있다.
			New_MemberDTO dto = dtos.get(i);
			String name = dto.getName();
			String id = dto.getId();
			String pw = dto.getPw();
			String phone = dto.getPhone1() + " - " + dto.getPhone2() + " - " + dto.getPhone3();
			String gender = dto.getGender();
			
			out.println("이름 : " + name + " 아이디 : " + id + " 비밀번호 : " + pw
				+ " 전화번호 : " + phone + " 성별 : " + gender + "<br/>");
		}
	%>
</body>
</html>