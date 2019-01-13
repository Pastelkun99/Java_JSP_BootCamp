<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	
	/* responseExample02.jsp로 보내고 있다. */
    System.out.println("responseExample01.jsp파일이 실행됨!");
    response.sendRedirect("responseExample02.jsp");
    
	%>
    