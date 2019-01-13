package sec01_exam_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 어노테이션을 이용하여 HelloWorld를 주소표시줄에 나타내지 않고, "/HWorld"로 나타내고 있다.

@WebServlet("/HWorld")

// Servlet파일이 되면 자동으로 HttpServlet상속을 받는다.

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 생성자 부분
    public HelloWorld() {
        super();
    }

	// 여기서 2가지의 메서드가 나오는데 doGet과 doPost이다.
    // 이것은 이 서블릿 파일이 처리하는 부분이다. 이 서블릿이 호출할때 get방식이냐? post방식이냐에 따라
    // 호출이 되는 것이다. 보통 doGet메서드는 폼을 그냥 출력하는 형태로 많이 쓰이고,
    // doPost메서드는 데이터를 가공이나 처리할 때 쓰인다.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 당연히 아래부분은 콘솔창에 찍히는 것은 이미 잘 알고 있다.
		System.out.println("HelloWorld");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 결론
	// 1. jsp파일 : html 파일내에 jsp코드를 넣는 것
	// 2. servlet파일 : 자바 파일이며, 아울러 매핑을 해서 사용해야 한다.

}
