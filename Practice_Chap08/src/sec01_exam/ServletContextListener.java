package sec01_exam;

import javax.servlet.ServletContextEvent;

// ������ Ŭ������ �ϳ� ���� ��������� �Ѵ�. ����, ServletContextListener �������̽���
// �����ؾ��Ѵ�. �Ʒ��� ���� ������̼��� �����Ϸ��� ���� web.xml���Ͽ� listener�±׸�
// �ּ�ó���ؾ��Ѵ�. �Ʒ� 2���� �ݹ� �޼���� �����ø����̼� ���۽�, ����� �ڵ� ȣ��ȴ�.

// @WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
	
	// �� �ݹ� �޼������ �ٸ� �����ø����̼��� ����� ������ ���� ����ǹǷ�
	// �� ������Ʈ������ Ȯ���ϰ� �ּ�ó���ϴ� ���� ���� ���̴�.

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//System.out.println("contextInitializedȣ��");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//System.out.println("contextDestoryedȣ��");
	}

	
}
