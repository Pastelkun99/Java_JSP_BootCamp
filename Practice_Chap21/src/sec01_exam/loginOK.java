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

@WebServlet("/loginOK")
public class loginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// �ʵ� ����
	private String id, pw, name, eMail, address, rDate;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/sqldb";
	// private String url = "jdbc:mysql://localhost/sqldb?" + "useUnicode=true&characterEncoding=UTF-8";
	
	private String uid = "root";
	private String upw = "1234";
	
	// DB���� ��ü ����
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet set = null;
	
    public loginOK() {
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
		// form �±׸� �̿��� ������ �� �޾ƿ���
		request.setCharacterEncoding("UTF-8");
		// ������ ���� ������ ���� session��ü�� ����ִ�.
		HttpSession httpsession = request.getSession();
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		// ���� �ۼ�(login.jsp)���� �Է��� id�� pw���� db�� �����ϴ��� Ȯ���ϴ� ����
		try {
			System.out.println(id);
			System.out.println(pw);
			
			// ����̹� ��ü �ε�
			Class.forName(driver);
			
			// Ŀ�ؼ� ��ü ���
			conn = DriverManager.getConnection(url, uid, upw);
			String query = "select * from members where id = ?" + "and pw=?";
			System.out.println(query);
			System.out.println(id);
			System.out.println(pw);
			psmt = conn.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			set = psmt.executeQuery();
			
			// System.out.println(set.next());
			// �α��� ������ Ȯ���ϴ� ���̴ϱ� �� ������ �ѹ��� �� ���̴�.
			if(set.next()) {
				// System.out.println("next()");
				// System.out.println(pw);
				if(id.equals(set.getString("id")) && pw.equals(set.getString("pw"))) {
					System.out.println("equals()");
					id = set.getString("id");
					pw = set.getString("pw");
					name = set.getString("name");
					eMail = set.getString("eMail");
					address = set.getString("address");
					rDate = set.getString("rDate");
					
					// session�� ž��
					httpsession.setAttribute("id", id);
					httpsession.setAttribute("pw", pw);
					httpsession.setAttribute("name", name);
					httpsession.setAttribute("rDate", rDate);
					
					// �α��ο� �����ߴٸ� loginResult.jsp�� �̵��϶�.
					response.sendRedirect("loginResult.jsp");
				}
			}
			// �����ð� ���ٸ�?
			else {
				// loginFail.jsp�� �̵��϶�.
				System.out.println("�̺κ��� �����");
				response.sendRedirect("loginFail.jsp");
			}
		} catch (Exception e) { e.printStackTrace(); }
		finally {
			try {
				// �ڿ� ����
				if(set != null) set.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) { e2.printStackTrace(); }
		}
	}

}
