<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	// fileupload.jsp에서 넘어오는 데이터를 받고 있다.
    	String name = request.getParameter("name");
    	String subject = request.getParameter("subject");
    	String filename1 = request.getParameter("filename1");
    	String filename2 = request.getParameter("filename2");
    	String origfilename1 = request.getParameter("origfilename1");
    	String origfilename2 = request.getParameter("origfilename2");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 확인 및 다운로드</title>
</head>
<body>
	올린 사람 : <%=name %><br>
	제목 : <%=subject %><br>
<!-- 	파일을 다운로드 할 수 있도록 링크를 걸고 있다.
	보낼때 전달 파라메터가 file_name이라는 것에 주목하자. -->
	파일명1 : <a href="file_down.jsp?file_name=<%=filename1 %>"><%=origfilename1 %></a><br>
	파일명2 : <a href="file_down.jsp?file_name=<%=filename2 %>"><%=origfilename2 %></a><br>
</body>
</html>