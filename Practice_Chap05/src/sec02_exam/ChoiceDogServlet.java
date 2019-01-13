package sec02_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/choiceDog")
public class ChoiceDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChoiceDogServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String[] select = request.getParameterValues("dog");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body bgcolor='black'>");
		writer.println("<table align='center' bgcolor='yellow'>");
		writer.println("<tr>");
		
		for(int i = 0; i<select.length; i++) {
			writer.println("<td>");
			writer.println("<img src = 'C:\\Users\\PC\\Desktop\\JSPÀÛ¾÷\\Practice_Chap05\\WebContent\\WEB-INF\\" + select[i] + "'/>");
			writer.println("</td>");
		}
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
		
		
	}

}
