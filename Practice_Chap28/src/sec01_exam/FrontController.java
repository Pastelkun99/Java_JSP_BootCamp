package sec01_exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �Ʒ��� ���� ������̼��� ������ Ȯ���ڰ� do�� ȣ��Ǹ� ���� �� �������� ã�ƿ��� �ȴ�.
// �̰��� �ڷῡ�� ���� FrontController�̴�.
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
	
	// �Ʒ��� ���� FrontController���Ͽ� ���� �� ������ ���ߵǾ ��û���� ���� ó���ϰ� �Ǹ�
	// ����� �ҽ��� ������� �����ϰ� �ȴ�. ����, command������ ���ٿ� �ָ� ������ ���̴�.
	private void actionDo(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("actionDo()");
		// uri(uniform resource identifier)�� �����ϴ� �ڿ��� �ĺ��ϱ� ����
		// �Ϲ����� �ĺ��ڸ� �����ϱ� ���� ������ url(uniform resourse locator)����
		// http ��������, ȣ��Ʈ��, port��ȣ�� ������ ���̴�.
		String uri = request.getRequestURI();
		System.out.println("uri = " + uri);
		
		// �� ������Ʈ�� ���ؽ�Ʈ�н��� �����´�.
		String conPath = request.getContextPath();
		System.out.println("conpath = " + conPath);
		
		// ���ؽ�Ʈ�н����� �� ���̸�ŭ �ڸ��� �����ϰ� �ִ�.
		// �� �޼������ �����ϴ� ���̴�.
		String command = uri.substring(conPath.length());
		System.out.println("command = " + command);
		
		// command�� ���� �޼��带 ȣ��(�б�)�ϰ� �ִ� ���¿� �����ϴ�.
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
