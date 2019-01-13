package sec01_exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 아래와 같이 어노테이션을 적으면 확장자가 do로 호출되면 전부 이 서블릿으로 찾아오게 된다.
// 이것이 자료에서 말한 FrontController이다.
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	// 아래와 같이 FrontController패턴에 따라 이 서블릿에 집중되어서 요청들을 전부 처리하게 되면
	// 상당히 소스가 길어지고 복잡하게 된다. 따라서, command패턴을 덧붙여 주면 괜찮을 것이다.
	private void actionDo(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("actionDo()");
		// uri(uniform resource identifier)는 존재하는 자원을 식별하기 위한
		// 일반적인 식별자를 규정하기 위한 것으로 url(uniform resourse locator)에서
		// http 프로토콜, 호스트명, port번호를 제외한 것이다.
		String uri = request.getRequestURI();
		System.out.println("uri = " + uri);
		
		// 이 프로젝트의 컨텍스트패스를 가져온다.
		String conPath = request.getContextPath();
		System.out.println("conpath = " + conPath);
		
		// 컨텍스트패스에서 그 길이만큼 자르고 리턴하고 있다.
		// 즉 메서드명을 리턴하는 것이다.
		String command = uri.substring(conPath.length());
		System.out.println("command = " + command);
		
		// command에 따라 메서드를 호출(분기)하고 있는 형태와 동일하다.
		if(command.equals("/insert.do")) {
			System.out.println("insert");
			System.out.println("---------------------------------");
		}
		else if(command.equals("/update.do")) {
			System.out.println("update");
			System.out.println("---------------------------------");
		}
		else if(command.equals("/select.do")) {
			System.out.println("select");
			System.out.println("---------------------------------");
		}
		else if(command.equals("/delete.do")) {
			System.out.println("delete");
			System.out.println("---------------------------------");
		}
	}

}
