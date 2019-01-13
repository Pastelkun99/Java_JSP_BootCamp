<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록을 봅니다.</title>
</head>
<body>
	<h1> 생성된 회원 목록 입니다. </h1>
	<%
    	Connection conn = null;
    	PreparedStatement psmt = null;
    	ResultSet set = null;
    	
    	String id, pw, name, eMail, address, rDate;
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost/sqldb";
    	String uid = "root";
    	String upw = "1234";
    	
    	String query = "select * from members";
    	
    	try {
    		Class.forName(driver);
        	conn = DriverManager.getConnection(url, uid, upw);
        	psmt = conn.prepareStatement(query);
        	set = psmt.executeQuery();
        	
        	while(set.next()) {
        		id = set.getString("id");
        		pw = set.getString("pw");
        		name = set.getString("name");
        		eMail = set.getString("eMail");
        		rDate = set.getString("rDate");
        		out.println("아이디 : " + id + "	비밀번호 : " + pw + "	이름 : " + name + "		이메일 주소 : " + eMail + 
        					"		생성일자 : " + rDate + "<br/>");
        	}
    	} catch(Exception e) { e.printStackTrace();	}
    	finally {
    		try {
    			//자원 해제
    			if(set != null) {set.close();}
    			if(psmt != null) {psmt.close();}
    			if(conn != null) {conn.close();}
    		} catch(Exception e2) { e2.printStackTrace(); }
    	}
    %>
    <br/>
    <a href="login.jsp">메인으로 돌아가기</a>
</body>
</html>