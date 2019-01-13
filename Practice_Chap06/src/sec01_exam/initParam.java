package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1번째 방법
// web.xml에 현재 서블릿 매핑을 진행했기 때문에 어노테이션은 주석처리한다.
// @WebServlet("/initParam")

// 2번째 방법
// 아래와 같이 어노테이션을 적용하기 위해서는 web.xml에 기술되어 있는 부분을 일단
// 주석처리해야 아래부분이 코드에 적용된다.
// 지금은 어노테이션에 직접 초기화 파라메터를 지정해주고 있다.
/*@WebServlet( urlPatterns= {"/initP"},
			 initParams = {
					 @WebInitParam(name="id", value="admin"),
					 @WebInitParam(name="pw", value="asddfg12"),
					 @WebInitParam(name="path" value="D:\\jsp작업")
			 })*/

@WebServlet("/initParam")
public class initParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public initParam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget()호출");
		// 상속 계층도를 쉽게 보려면 ctrl+T를 사용한다.
		// servletConfig(인터페이스)의 추상메서드를 HttpServlet에서 구현했다.
		// 현재 this가지 자신의 주소를 가지고 있는 것을 이미 자바에서 배웠다.
		// getInitParameter()는 Httpservlet 조상클래스에 선언되어있는 메서드이다.
		
		String id = this.getInitParameter("id");
		String pw = this.getInitParameter("pw");
		String path = this.getInitParameter("path");
		
		// 클라이언트에게 보여줄 방식 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter(); 		// 출력 스트림을 얻는다.
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br/>");
		writer.println("비밀번호 : " + pw + "<br/>");
		writer.println("경로 : " + path + "<br/>");
		writer.println("</body></html>");
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
