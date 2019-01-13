<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	BoardBean bean = (BoardBean)request.getAttribute("bean");
    	String nowPage = (String)request.getAttribute("page");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<script lang= "javascript"></script>
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
	<!-- 게시판 답변 -->
	<section id="writeForm">
		<h2>게시판 글 등록</h2>
		<form action="boardReplyPro.bo" method="post" name="boardform">
			<input type="hidden" name="page" value="<%=nowPage %>"/>
			<input type="hidden" name="BOARD_NUM" value="<%=bean.getBOARD_NUM() %>">
			<input type="hidden" name="BOARD_RE_REF" value="<%=bean.getBOARD_RE_REF() %>">
			<input type="hidden" name="BOARD_RE_LEV" value="<%=bean.getBOARD_RE_LEV() %>">
			<input type="hidden" name="BOARD_RE_SEQ" value="<%=bean.getBOARD_RE_SEQ() %>">
		<table>
			<tr>
				<td class="td_left"><label>글쓴이</label></td>
				<td class="td_right">
				<input type="text" name="BOARD_NAME" id="BOARD_NAME" /></td>
			</tr>
			<tr>
				<td class="td_left"><label>비밀번호</label></td>
				<td class="td_right"><input name="BOARD_PASS" type="password" id="BOARD_PASS"/>
				</td>
			</tr>
			<tr>
				<td class="td_left"><label>제 목</label></td>
				<td class="td_right"><input name="BOARD_SUBJECT" type="text" id="BOARD_SUBJECT"/></td>
			</tr>
			<tr>
				<td class="td_left"><label>내 용</label></td>
				<td>
					<textarea id="BOARD_CONTENT" name="BOARD_CONTENT" cols="40" rows="15"></textarea>
				</td>
			</tr>
		</table>
		<section id="commandCell">
			<input type="submit" value="답변글 등록"/> &nbsp;&nbsp;
			<input type="reset" value="다시 작성"/>
		</section>
		</form>
	</section>
</body>
</html>