<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request TEST</title>
<!-- 스타일 적용 코드 -->
<style>
h1, #CommandCell {
	text-align: center;
}
table {
	margin: auto;
	width: 400px;
	border: 1px solid red;
	background-color: yellow;
}
</style>
</head>
<body>
	<h1>Request 예제</h1>
	<!-- requestExample01.jsp파일에 post방식으로 요청중 -->
	<form action="requestExample01.jsp" method="post">
		<!-- 테이블 생성 -->
		<table border="1">
			<tr> <!-- 첫번째 행 -->
				<td><label>이름</label></td>
				<td><input type="text" name="name" id="name">
				</td>
			</tr>
			<tr>
				<td><label>성별</label></td>
				<td>
				남<input type="radio" name="gender" value="남자" id="gender">
				여<input type="radio" name="gender" value="여자">
				</td>
			</tr>
			<tr> <!-- 두번째 행 -->
				<td><label>취미</label></td>
				<td>
				독서<input type="checkbox" name="hobby" value="독서" id="hobby">
				게임<input type="checkbox" name="hobby" value="게임">
				TV 시청<input type="checkbox" name="hobby" value="TV시청">
				축구<input type="checkbox" name="hobby" value="축구">
				기타<input type="checkbox" name="hobby" value="기타">
				</td>
			</tr>
			<tr> <!-- 세번째 행 -->
				<td colspan="2" id="CommandCell">
				<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>