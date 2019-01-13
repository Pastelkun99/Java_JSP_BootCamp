package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextinitP")
public class ContextinitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextinitParam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() ȣ��");
		//getServletContext()�� �̿��ؼ� web.xml�� context-param������ ������ �� �� �ִ�.
		String id = this.getServletContext().getInitParameter("id");
		String pw = this.getServletContext().getInitParameter("pw");
		String path = this.getServletContext().getInitParameter("path");
		
		// Ŭ���̾�Ʈ���� ������ ��� ����
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter(); 		// ��� ��Ʈ���� ��´�.
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id + "<br/>");
		writer.println("��й�ȣ : " + pw + "<br/>");
		writer.println("��� : " + path + "<br/>");
		writer.println("</body></html>");
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
