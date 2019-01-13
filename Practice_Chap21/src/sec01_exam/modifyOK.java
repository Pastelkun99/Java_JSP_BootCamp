package sec01_exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/modifyOK")
public class modifyOK extends HttpServlet {
			
	private static final long serialVersionUID = 1L;
       
		// 필드 선언
		private String id, pw, name, eMail, address, rDate;
		private String driver = "com.mysql.jdbc.Driver";
		private String url = "jdbc:mysql://localhost/sqldb";
		// private String url = "jdbc:mysql://localhost/sqldb?" + "useUnicode=true&characterEncoding=UTF-8";
		
		private String uid = "root";
		private String upw = "1234";
			
		// DB연결 객체 선언
		private Connection connection = null;
		private PreparedStatement psmt = null;
		private ResultSet set = null;
		HttpSession httpsession = null;
			
   	   	public modifyOK() {
	        super();
   	   	}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doGet() 호출");
			actionDo(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doPost() 호출");
			actionDo(request, response);
		}
			
		private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			httpsession = request.getSession();
				
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			name = request.getParameter("name");
			eMail = request.getParameter("eMail");
			address = request.getParameter("address");
			
			// 패스워드 인증을 통과하면 아래 쿼리를 실행합니다.
			if(pwConfirm() == true) {
				// System.out.println("ok");
				// 수정한 회원정보를 DB에 업데이트하기 위한 쿼리문
				String query = "update members set name = ?, eMail = ?, address = ? where id = ?";
				
				try {
					Class.forName(driver);
					connection = DriverManager.getConnection(url, uid, upw);
					psmt = connection.prepareStatement(query);
					
					psmt.setString(1, name);
					psmt.setString(2, eMail);
					psmt.setString(3, address);
					psmt.setString(4, id);
						
					int i = psmt.executeUpdate();
						
					if(i == 1) {
						httpsession.setAttribute("name", name);
						httpsession.setAttribute("id", id);
						httpsession.setAttribute("pw", pw);
						response.sendRedirect("modifyResult.jsp");
					} else {
						System.out.println("실패");
					}
				} catch (Exception e) { e.printStackTrace(); }
				finally {
					try {
						if(psmt != null) { psmt.close(); }
						if(connection != null) { connection.close(); }
					} catch (Exception e2) { e2.printStackTrace(); }					
				}
			} else {
				// 패스워드 인증에 실패하면 아래와 같이 실행됨
				System.out.println("안맞네 ㅋㅋ");
				response.sendRedirect("modify.jsp");
			}
		}
		
		private boolean pwConfirm() {
			
			boolean rs = false;
			// 세션에서 pw값을 얻는다.
			String sessionpw = (String)httpsession.getAttribute("pw");
			
			// 사용자가 입력한 값과 같으면 true, 아니면 false를 리턴합니다.
			if(sessionpw.equals(pw)) {
				rs = true;
			} else {
				rs = false;
			}
			return rs;
		}
	}
