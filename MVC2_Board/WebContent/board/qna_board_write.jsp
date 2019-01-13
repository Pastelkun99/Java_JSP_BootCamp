<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 610px;
	border: 1px solid red;
	margin: auto;
}
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 450px;
}
.td_left {
	width: 150px;
	background: orange;
}
.td_right {
	width: 300px;
	background: skyblue;
}
#commandCell {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 게시판 등록 -->
	<section id="registForm">
		<h2>게시판 글 등록</h2>
		<form action="boardWritePro.bo" method="post" enctype="multipart/form-data" name="boardform">
			<table>
				<tr>
					<td class="td_left"><label>글쓴이</label></td>
					<td class="td_right"><input type="text" name="BOARD_NAME" id="BOARD_NAME" required="required"/></td>
				</tr>
				<tr>
					<td class="td_left"><label>비밀번호</label></td>
					<td class="td_right"><input type="password" name="BOARD_PASS" id="BOARD_PASS" required="required"/></td>
				</tr>
					<tr>
					<td class="td_left"><label>제 목</label></td>
					<td class="td_right"><input type="text" name="BOARD_SUBJECT" id="BOARD_SUBJECT" required="required"/></td>
				</tr>
				<tr>
					<td class="td_left"><label>내 용</label></td>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT" rows="15" cols="40"></textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label>파일 첨부</label></td>
					<td class="td_right"><input name="BOARD_FILE" type="file" id="BOARD_FILE" required="required"/></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록"> &nbsp;&nbsp;
				<input type="reset" value="다시쓰기"/>
			</section>
		</form>
	</section>
	<!-- 게시판 등록 -->
</body>
</html>