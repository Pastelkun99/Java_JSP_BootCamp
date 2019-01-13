<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	// 하나의 게시글과 현재페이지를 request로부터 받고있다.
    	BoardBean bean = (BoardBean)request.getAttribute("BoardBean");
    	String nowPage = (String)request.getAttribute("page");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<style type="text/css">
	#articleForm {
		width: 500px;
		height: 500px;
		border: 1px solid red;
		margin: auto;
	}
	h2 {
		text-align: center;
	}
	#basicInfoArea {
		height: 40px;
		text-align: center;
	}
	#articleContentArea {
		background: orange;
		margin-top: 20px;
		height: 200px;
		text-align: center;
		overflow: auto;
	}
	#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
</style>
</head>
<body>
	<section id="articleForm">
		<h2>글 내용 상세 보기</h2>
		<section id="basicInfoArea">
			제목 : <%=bean.getBOARD_SUBJECT() %>
			첨부파일 : <% if(!(bean.getBOARD_FILE() == null)) { %>
			<a href="file_down?downFile=<%=bean.getBOARD_FILE() %>"><%=bean.getBOARD_FILE() %></a>
			<% } %>
		</section>
		<section id="articleContentArea">
			<%=bean.getBOARD_CONTENT() %>
		</section>
	</section>
	<section id="commandList">
		<a href="boardReplyForm.bo?board_num=<%=bean.getBOARD_NUM() %>&page=<%=nowPage %>">[답변]</a>
		<a href="boardModifyForm.bo?board_num=<%=bean.getBOARD_NUM() %>&page=<%=nowPage %>">[수정]</a>
		<a href="boardDeleteForm.bo?board_num=<%=bean.getBOARD_NUM() %>&page=<%=nowPage %>">[삭제]</a>
		<a href="boardList.bo?page=<%=nowPage %>">[목록]</a>&nbsp;&nbsp;
	</section>
</body>
</html>