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
       
		// �ʵ� ����
		private String id, pw, name, eMail, address, rDate;
		private String driver = "com.mysql.jdbc.Driver";
		private String url = "jdbc:mysql://localhost/sqldb";
		// private String url = "jdbc:mysql://localhost/sqldb?" + "useUnicode=true&characterEncoding=UTF-8";
		
		private String uid = "root";
		private String upw = "1234";
			
		// DB���� ��ü ����
		private Connection connection = null;
		private PreparedStatement psmt = null;
		private ResultSet set = null;
		HttpSession httpsession = null;
			
   	   	public modifyOK() {
	        super();
   	   	}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doGet() ȣ��");
			actionDo(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doPost() ȣ��");
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
			
			// �н����� ������ ����ϸ� �Ʒ� ������ �����մϴ�.
			if(pwConfirm() == true) {
				// System.out.println("ok");
				// ������ ȸ�������� DB�� ������Ʈ�ϱ� ���� ������
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
						System.out.println("����");
					}
				} catch (Exception e) { e.printStackTrace(); }
				finally {
					try {
						if(psmt != null) { psmt.close(); }
						if(connection != null) { connection.close(); }
					} catch (Exception e2) { e2.printStackTrace(); }					
				}
			} else {
				// �н����� ������ �����ϸ� �Ʒ��� ���� �����
				System.out.println("�ȸ³� ����");
				response.sendRedirect("modify.jsp");
			}
		}
		
		private boolean pwConfirm() {
			
			boolean rs = false;
			// ���ǿ��� pw���� ��´�.
			String sessionpw = (String)httpsession.getAttribute("pw");
			
			// ����ڰ� �Է��� ���� ������ true, �ƴϸ� false�� �����մϴ�.
			if(sessionpw.equals(pw)) {
				rs = true;
			} else {
				rs = false;
			}
			return rs;
		}
	}
