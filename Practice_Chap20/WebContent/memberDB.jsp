<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	// 아래와 같이 선언할때 ctrl+space바를 누르면 자동완성이 됨과 동시에 자동으로 import된다.
	Connection connection; 		// 연결 객체 선언
	Statement statement;		// 쿼리문 실행 객체 선언
	ResultSet resultset;		// 쿼리문의 실행 결과를 받아내는 객체 선언
	String driver = "com.mysql.jdbc.Driver"; 		//드라이버 명시
	String url = "jdbc:mysql://localhost:3306/sqldb";		// 도메인. 포트번호와 접속 db명
	String id = "root";		// 접속 아이디
	String pw = "1234";		// 접속 비밀번호
	String query = "select * from member order by name";	// 쿼리문 작성
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		try {
			// 하기의 순서는 반드시 알아두어야 한다. 그래야 접속도 하고, 쿼리도 전송할 수 있다.
			// 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			// Connection 객체를 DriverManager 클래스를 통해 id, pw, url을 주고받는다.
			connection = DriverManager.getConnection(url, id, pw);
			
			// 쿼리문을 실행할 Statement객체를 connection객체로 얻음
			statement = connection.createStatement();
			
			// 쿼리문의 결과가 resultset객체에 담기기 때문에 BOF를 커서가 가리키고 있다.
			resultset = statement.executeQuery(query);
			
			// 따라서 아래와 같이 루프를 돌면서 EOF를 만날때 까지 하나씩 데이터를 가져온다.
			
			// 가져올게 있는가?
			while(resultset.next()) {
				String id = resultset.getString("id");
				String pw = resultset.getString("pw");
				String name = resultset.getString("name");
				String phone = resultset.getString("phone");
				
				out.println("아이디 : " + id + "	비밀번호 : " + pw + "	이름 : " + name + "		전화번호 : " + phone + "<br/>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 이미 자바에서 학습했다. finally 부분은 예외 실행이 됐던 안됐던 무조건 실행된다.
			try {
				// 위에서 사용한 리소스를 해제함.
				if(resultset != null) {	resultset.close(); }
				if(statement != null) {	statement.close(); }
				if(connection != null) { connection.close(); }
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
%>
</body>
</html>