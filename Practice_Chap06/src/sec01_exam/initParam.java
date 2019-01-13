package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1��° ���
// web.xml�� ���� ���� ������ �����߱� ������ ������̼��� �ּ�ó���Ѵ�.
// @WebServlet("/initParam")

// 2��° ���
// �Ʒ��� ���� ������̼��� �����ϱ� ���ؼ��� web.xml�� ����Ǿ� �ִ� �κ��� �ϴ�
// �ּ�ó���ؾ� �Ʒ��κ��� �ڵ忡 ����ȴ�.
// ������ ������̼ǿ� ���� �ʱ�ȭ �Ķ���͸� �������ְ� �ִ�.
/*@WebServlet( urlPatterns= {"/initP"},
			 initParams = {
					 @WebInitParam(name="id", value="admin"),
					 @WebInitParam(name="pw", value="asddfg12"),
					 @WebInitParam(name="path" value="D:\\jsp�۾�")
			 })*/

@WebServlet("/initParam")
public class initParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public initParam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget()ȣ��");
		// ��� �������� ���� ������ ctrl+T�� ����Ѵ�.
		// servletConfig(�������̽�)�� �߻�޼��带 HttpServlet���� �����ߴ�.
		// ���� this���� �ڽ��� �ּҸ� ������ �ִ� ���� �̹� �ڹٿ��� �����.
		// getInitParameter()�� Httpservlet ����Ŭ������ ����Ǿ��ִ� �޼����̴�.
		
		String id = this.getInitParameter("id");
		String pw = this.getInitParameter("pw");
		String path = this.getInitParameter("path");
		
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
