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
		System.out.println("GetOrPostMehtodCall.java에 있는 doGet() 호출");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("안녕하세요");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>doGet방식입니다. ~~~ Hello World ~~~ !!! </h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetOrPostMehtodCall.java에 있는 doPost() 호출");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("안녕하세요");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>doPost방식입니다. ~~~ Hello World ~~~ !!! </h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		// Server 프로젝트에 가서 ContextPath에 대해서 확인하자. server.xml 파일을 xsleditor로 열어보자.
	}

}
