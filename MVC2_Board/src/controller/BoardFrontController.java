package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteProAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardWriteProAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null; 		// 보여줄 뷰페이지를 설정하는 객체
		Action action = null;				// 커맨드패턴의 인터페이스
		
		// 요청에 따라 분기를 하고 있다.
		if(command.equals("/boardWriteForm.bo")) {
			forward = new ActionForward();						// 요청페이지로 이동하는 객체 생성
			forward.setPath("/board/qna_board_write.jsp");		// 이동경로 지정
		}
		// 게시판 글쓰기 등록을 눌렀을때 실행한다.
		else if(command.equals("/boardWritePro.bo")) {
			action = new BoardWriteProAction();
			try {
				// Action 인터페이스를 구현한 BoardWriteProAction클래스의
				// 오버라이딩 된 execute()를 호출한다.
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// DB에 있는 게시글 리스트를 가져와서 출력하는 부분
		else if(command.equals("/boardList.bo")) {
			action = new BoardListAction();
			try {
				// Action인터페이스를 구현한 BoardListAction클래스의
				// 오버라이딩 된 execute()를 호출한다.
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		// 상세 글보기 
		else if(command.equals("/boardDetail.bo")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardReplyForm.bo")) {
			action = new BoardReplyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 답변 글 쓰기 등록을 눌렀을 때 명령을 수행하는 부분.
		else if(command.equals("/boardReplyPro.bo")) {
			action = new BoardReplyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardModifyForm.bo")) {
			action = new BoardModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 수정하기 폼에서 수정 완료 후 수정 버튼을 눌렀을떄 명령을 수행하는 부분
		else if(command.equals("/boardModifyPro.bo")) {
			action = new BoardModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 글 상세 보기 후 삭제 부분을 눌렀을때 명령을 수행하는 부분
		else if(command.equals("/boardDeleteForm.bo")) {
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			request.setAttribute("board_num", board_num);
			forward = new ActionForward();
			forward.setPath("/board/qna_board_delete.jsp");
		}
		// 실제 게시글을 삭제하는 명령이 이루어지는 부분
		else if(command.equals("/boardDeletePro.bo")) {
			action = new BoardDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		// 이동경로로 이동
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
