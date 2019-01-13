package sec01_exam;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LC")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle() {
        super();
        System.out.println("������ ȣ��");
    }

    // init() ctrl + space�� ���� ���� �Է��Ͽ� �ڵ�����. ���� 1�� ����ȴ�.
    @Override
    public void init() throws ServletException {
    	System.out.println("init() ȣ��");
    }
    
    // destory()�� ctrl + space�� ���� ���� �Է��Ͽ� �ڵ�����.
    // ������ �������Ѻ��� destory()�� ȣ��Ǵ� ���� �� �� �ִ�.
    @Override
    public void destroy() {
    	System.out.println("destory() ȣ��");
    }
    
    
    // ���ΰ�ħ�� ��� �ϸ� URL�� ���� �����߱� ������ doGet()�� ��� ȣ����� �� �� �ִ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() ȣ��");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ȣ��");
	}

	// �������̵��� ������ �ƴϴ�. ���� �޼��带 ������ִ� ���̴�. (�߿�)
	// ��ó�� �κ��̴�. ���� �ڵ����ִµ�, �� �κ��� ppt������ �����ߵ��� 
	// init()�޼��尡 ȣ��Ǿ����� ���� ���� ������� �˵��� ����.
	// �� ������ �Ʒ��� �ִ� @PostConstruct ������̼��� �����Ϸ����� ���� �����ϴ� ���̴�.
	@PostConstruct
	private void initPostConstructor() {
		System.out.println("initPostConstructor() ȣ��");
	}
	
	// �̰��� destory() �޼��尡 ȣ��� �� �ڿ� ������� �˾Ƶ���.
	// �Ʒ��� �ִ� @PreDestroy ������̼��� �����Ϸ����� ���� �����ϴ� ���̴�.
	@PreDestroy
	private void destroyPredestroy() {
		System.out.println("destroyPredestroy() ȣ��");
	}
	
	// �Ʒ��� service()�� ������ �� �κ��ε�, doGet �� doPost�� ���ٸ�
	// service()�� ȣ���Ѵ�. �ƿ﷯ �� �� �����ص� service()�� ȣ��ȴ�.
	// ������ ��� doGet()�� doPost()�� �̿��� �ڵ��Ѵ�.
	
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() ȣ��");
	}*/
}
