<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 아래는 선언부를 가지고 자바코드를 이용했다. 이런 부분은 전역변수의 성질을 가진다. 따라서 어디서든 사용가능 -->
	
	<%!
		int i = 10;
		String str = new String("abcde");
		
		public int add(int a, int b) {
			return a + b;
		}
	%>
	
	i 값 : <% out.println(i + "<br/>"); %>
	str 값 : <% out.println(str.toString() + "<br/>"); %>
	add 메서드에 1000, 5000을 매개변수로 주고 호출하여 얻은 값 : <% out.println(add(1000, 5000)); %>
</body>
</html>