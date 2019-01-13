<%@page import="sec01_exam.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sec01_exam.MemberDAO"%>
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
		// MemberDAO 를 생성하고 memberSelect()를 호출하고 있다.
		MemberDAO memberDao = new MemberDAO();
		ArrayList<MemberDTO> dtos = memberDao.memberSelect();
		// 반환값으로 얻은 ArrayList<MemberDTO>를 하나씩 얻어서 출력하고 있다.
		for(int i = 0; i<dtos.size(); i++) {
			// ArrayList<MemberDTO> 에서 추가된 MemberDTO객체를 하나씩 꺼내고 있다.
			System.out.println("for문 들어옴");
			MemberDTO dto = dtos.get(i);
			String name = dto.getName();
			String id = dto.getId();
			String pw = dto.getPw();
			String phone = dto.getPhone1() + " - " + dto.getPhone2() + " - " + dto.getPhone3();
			String gender = dto.getGender();
			out.println("이름 : " + name + " 아이디 : " + id + " 비밀번호 : " + pw + " 전화번호 : " + phone + " 성별 : " + gender + "<br/>");
		}
	%>
</body>
</html>