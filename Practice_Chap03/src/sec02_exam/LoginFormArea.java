package sec02_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")

public class LoginFormArea extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginFormArea() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget() 호출");
		/*클라이언트에서 넘어오는 id와 passwd값을 받고 인코딩 설정 후 출력스트림을 얻고 화면에 뿌려준다.*/
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("아이디 = " + id + "<br>");
		out.println("비밀번호 = " + passwd + "<br>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
