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
	
	// 필드 선언
	private String id, pw, name, eMail, address, rDate;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/sqldb";
	// private String url = "jdbc:mysql://localhost/sqldb?" + "useUnicode=true&characterEncoding=UTF-8";
	
	private String uid = "root";
	private String upw = "1234";
	
	// DB연결 객체 선언
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet set = null;
	
    public loginOK() {
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
		// form 태그를 이용한 데이터 값 받아오기
		request.setCharacterEncoding("UTF-8");
		// 서버와 연결 유지를 위해 session객체를 얻고있다.
		HttpSession httpsession = request.getSession();
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		// 쿼리 작성(login.jsp)에서 입력한 id와 pw값을 db에 존재하는지 확인하는 쿼리
		try {
			System.out.println(id);
			System.out.println(pw);
			
			// 드라이버 객체 로드
			Class.forName(driver);
			
			// 커넥션 객체 얻기
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
			// 로그인 정보를 확인하는 것이니까 이 루프는 한번만 돌 것이다.
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
					
					// session에 탑재
					httpsession.setAttribute("id", id);
					httpsession.setAttribute("pw", pw);
					httpsession.setAttribute("name", name);
					httpsession.setAttribute("rDate", rDate);
					
					// 로그인에 성공했다면 loginResult.jsp로 이동하라.
					response.sendRedirect("loginResult.jsp");
				}
			}
			// 가져올게 없다면?
			else {
				// loginFail.jsp로 이동하라.
				System.out.println("이부분이 실행됨");
				response.sendRedirect("loginFail.jsp");
			}
		} catch (Exception e) { e.printStackTrace(); }
		finally {
			try {
				// 자원 해제
				if(set != null) set.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) { e2.printStackTrace(); }
		}
	}

}
