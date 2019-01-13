package sec01_exam;

import javax.servlet.ServletContextEvent;

// 리스터 클래스를 하나 따로 생성해줘야 한다. 물론, ServletContextListener 인터페이스를
// 구현해야한다. 아래와 같이 어노테이션을 적용하려면 역시 web.xml파일에 listener태그를
// 주석처리해야한다. 아래 2개의 콜백 메서드는 웹어플리케이션 시작시, 종료시 자동 호출된다.

// @WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
	
	// 이 콜백 메서드들은 다른 웹어플리케이션이 실행될 떄에서 같이 실행되므로
	// 이 프로젝트에서만 확인하고 주석처리하는 것이 좋을 것이다.

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//System.out.println("contextInitialized호출");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//System.out.println("contextDestoryed호출");
	}

	
}
