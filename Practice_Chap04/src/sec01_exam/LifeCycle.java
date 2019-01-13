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
        System.out.println("생성자 호출");
    }

    // init() ctrl + space를 눌러 직접 입력하여 코딩하자. 최초 1번 실행된다.
    @Override
    public void init() throws ServletException {
    	System.out.println("init() 호출");
    }
    
    // destory()를 ctrl + space를 눌러 직접 입력하여 코딩하자.
    // 서버를 중지시켜보면 destory()가 호출되는 것을 알 수 있다.
    @Override
    public void destroy() {
    	System.out.println("destory() 호출");
    }
    
    
    // 새로고침을 계속 하면 URL로 직접 접속했기 때문에 doGet()이 계속 호출됨을 볼 수 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
	}

	// 오버라이딩의 개념이 아니다. 직접 메서드를 만들어주는 것이다. (중요)
	// 전처리 부분이다. 직접 코딩해주는데, 이 부분은 ppt에서도 설명했듯이 
	// init()메서드가 호출되어지기 전에 먼저 실행됨을 알도록 하자.
	// 그 역할은 아래에 있는 @PostConstruct 어노테이션이 컴파일러에게 따로 지시하는 것이다.
	@PostConstruct
	private void initPostConstructor() {
		System.out.println("initPostConstructor() 호출");
	}
	
	// 이것은 destory() 메서드가 호출된 후 뒤에 실행됨을 알아두자.
	// 아래에 있는 @PreDestroy 어노테이션이 컴파일러에게 따로 지시하는 것이다.
	@PreDestroy
	private void destroyPredestroy() {
		System.out.println("destroyPredestroy() 호출");
	}
	
	// 아래는 service()를 재정의 한 부분인데, doGet 과 doPost가 없다면
	// service()를 호출한다. 아울러 셋 다 존재해도 service()는 호출된다.
	// 하지만 통상 doGet()과 doPost()를 이용해 코딩한다.
	
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출");
	}*/
}
