package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetOrPostMethodCall")
public class GetOrPostMethodCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetOrPostMethodCall() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetOrPostMehtodCall.java�� �ִ� doGet() ȣ��");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("�ȳ��ϼ���");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>doGet����Դϴ�. ~~~ Hello World ~~~ !!! </h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetOrPostMehtodCall.java�� �ִ� doPost() ȣ��");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("�ȳ��ϼ���");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>doPost����Դϴ�. ~~~ Hello World ~~~ !!! </h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		// Server ������Ʈ�� ���� ContextPath�� ���ؼ� Ȯ������. server.xml ������ xsleditor�� �����.
	}

}
