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
	System.out.println("forwardExample02 지나감"); //콘솔창에서 지나감을 확인하는 것
	
	request.setCharacterEncoding("UTF-8");
		String name, age, address, phonenumber;
		name = request.getParameter("name");
		age = request.getParameter("age");
		address = request.getParameter("address");
	%>

	<%-- <jsp:forward page="<%=request.getParameter("forwardPage")%>">
	<jsp:param value="010-0101-1924" name="phonenumber"/>
	</jsp:forward> --%>
	
	<jsp:forward page="forwardExample03.jsp">
		<jsp:param value="<%=name%>" name="name" />
		<jsp:param value="<%=age%>" name="age" />
		<jsp:param value="<%=address%>" name="address" />
		<jsp:param value="123.4567.91011" name="phonenumber" />
	</jsp:forward>

</body>
</html>