package sec01_exam_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet ������̼��� �̿��Ͽ� HelloWorld�� �ּ�ǥ���ٿ� ��Ÿ���� �ʰ�, "/HWorld"�� ��Ÿ���� �ִ�.

@WebServlet("/HWorld")

// Servlet������ �Ǹ� �ڵ����� HttpServlet����� �޴´�.

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// ������ �κ�
    public HelloWorld() {
        super();
    }

	// ���⼭ 2������ �޼��尡 �����µ� doGet�� doPost�̴�.
    // �̰��� �� ���� ������ ó���ϴ� �κ��̴�. �� ������ ȣ���Ҷ� get����̳�? post����̳Ŀ� ����
    // ȣ���� �Ǵ� ���̴�. ���� doGet�޼���� ���� �׳� ����ϴ� ���·� ���� ���̰�,
    // doPost�޼���� �����͸� �����̳� ó���� �� ���δ�.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �翬�� �Ʒ��κ��� �ܼ�â�� ������ ���� �̹� �� �˰� �ִ�.
		System.out.println("HelloWorld");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// ���
	// 1. jsp���� : html ���ϳ��� jsp�ڵ带 �ִ� ��
	// 2. servlet���� : �ڹ� �����̸�, �ƿ﷯ ������ �ؼ� ����ؾ� �Ѵ�.

}
