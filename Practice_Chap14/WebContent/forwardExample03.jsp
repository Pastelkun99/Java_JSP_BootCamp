<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>03페이지 입니다</h1>
	<%
	request.setCharacterEncoding("UTF-8");
		String name, age, address, phonenumber;
	name = request.getParameter("name");
	age = request.getParameter("age");
	address = request.getParameter("address");
	phonenumber = request.getParameter("phonenumber");
	%>
	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=age%></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=address%></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=phonenumber%></td>
		</tr>
	
	</table>
	<!-- (중요)주소표시줄은 강의에서도 말했지만, forward를 사용한 곳의 url을 표시하고 있음을 기억하자
	forward액션 태그는 제어권을 포워딩 되는 페이지로 완전히 넘기고 그 페이지가 끝나면 모든 응답을 종료시킨다. -->
</body>
</html>