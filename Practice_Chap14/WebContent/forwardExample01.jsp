<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>포워드 액션 테스트</h2>
	<%-- <jsp:forward page="forwrd.jsp"></jsp:forward> --%>
	<form action="forwardExample02.jsp" method="post">
		<!-- hidden타입은 입력양식에 사용자로부터 값을 집접 입력받는 경우 사용하는 것이 아니고 특정이름의 파라미터 값을 코드상에서 직접 지정하여 전송하는 경우 사용한다. -->
		<input type="hidden" name="forwardPage" value="forwardExample03.jsp"> <!-- 02페이지에서 작업해서 03페이지로 넘어감 -->
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>