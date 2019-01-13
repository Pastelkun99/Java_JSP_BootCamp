package sec01_exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinOK")
public class joinOK extends HttpServlet {
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
		
	    public joinOK() {
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
			// request, response�� ����ϱ� ���� ����ó���� �Ѵ�.
			
			// �ѱ� ���� ����
			request.setCharacterEncoding("UTF-8");
			System.out.println("actionDo()");
			
			// form���� �Ѿ�� ������ ������ ������.
			id = request.getParameter("id");
			System.out.println(id);
			pw = request.getParameter("pw");
			System.out.println(pw);
			name = request.getParameter("name");
			System.out.println(name);
			eMail = request.getParameter("eMail");
			System.out.println(eMail);
			address = request.getParameter("address");
			System.out.println(address);
			
			Date now = new Date(); 	// ���� �ý����� ��¥�� �ð��� ����(�����Ͻ� ����)
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
			rDate = sdf.format(now);
			System.out.println(rDate.toString());
			
			String query = "insert into members(id, pw, name, eMail, " + "address, rDate)" + "values(?, ?, ?, ?, ?, ?)";
			
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, uid, upw);
				psmt = connection.prepareStatement(query);
				psmt.setString(1, id);
				// System.out.println(id);
				psmt.setString(2, pw);
				// System.out.println(pw);
				psmt.setString(3, name);
				// System.out.println(name);
				psmt.setString(4, eMail);
				// System.out.println(eMail);
				psmt.setString(5, address);
				// System.out.println(address);
				psmt.setString(6, rDate);
				// System.out.println(rDate);
				
				// PreparedStatement��ü�� executeUpdate()�� ��ȯ���� int�̱� ������
				// ����, ����, ���� �� �� ����Ǿ��� row�� �����Ѵ�.
				int i = psmt.executeUpdate();
				System.out.println(i);
				
				if(i == 1) {
					System.out.println(i);
					System.out.println("������ ���� ����!!!");
					response.sendRedirect("joinResult.jsp");
				} else {
					System.out.println(i);
					System.out.println("������ ���� ����...");
					response.sendRedirect("join.jsp");
				}
			} catch (Exception e) { e.printStackTrace(); }
			finally {
				try {
					// ���ҽ� ����
					if(psmt != null) { psmt.close(); }
					if(connection != null) { connection.close(); }
				} catch (Exception e2) { e2.printStackTrace(); }
			}
		}
}
