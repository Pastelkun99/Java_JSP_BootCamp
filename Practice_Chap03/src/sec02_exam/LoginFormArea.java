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
		System.out.println("doget() ȣ��");
		/*Ŭ���̾�Ʈ���� �Ѿ���� id�� passwd���� �ް� ���ڵ� ���� �� ��½�Ʈ���� ��� ȭ�鿡 �ѷ��ش�.*/
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("���̵� = " + id + "<br>");
		out.println("��й�ȣ = " + passwd + "<br>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
