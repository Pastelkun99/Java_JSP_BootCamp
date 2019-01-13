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
		ActionForward forward = null; 		// ������ ���������� �����ϴ� ��ü
		Action action = null;				// Ŀ�ǵ������� �������̽�
		
		// ��û�� ���� �б⸦ �ϰ� �ִ�.
		if(command.equals("/boardWriteForm.bo")) {
			forward = new ActionForward();						// ��û�������� �̵��ϴ� ��ü ����
			forward.setPath("/board/qna_board_write.jsp");		// �̵���� ����
		}
		// �Խ��� �۾��� ����� �������� �����Ѵ�.
		else if(command.equals("/boardWritePro.bo")) {
			action = new BoardWriteProAction();
			try {
				// Action �������̽��� ������ BoardWriteProActionŬ������
				// �������̵� �� execute()�� ȣ���Ѵ�.
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// DB�� �ִ� �Խñ� ����Ʈ�� �����ͼ� ����ϴ� �κ�
		else if(command.equals("/boardList.bo")) {
			action = new BoardListAction();
			try {
				// Action�������̽��� ������ BoardListActionŬ������
				// �������̵� �� execute()�� ȣ���Ѵ�.
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		// �� �ۺ��� 
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
		// �亯 �� ���� ����� ������ �� ����� �����ϴ� �κ�.
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
		// �����ϱ� ������ ���� �Ϸ� �� ���� ��ư�� �������� ����� �����ϴ� �κ�
		else if(command.equals("/boardModifyPro.bo")) {
			action = new BoardModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �� �� ���� �� ���� �κ��� �������� ����� �����ϴ� �κ�
		else if(command.equals("/boardDeleteForm.bo")) {
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			request.setAttribute("board_num", board_num);
			forward = new ActionForward();
			forward.setPath("/board/qna_board_delete.jsp");
		}
		// ���� �Խñ��� �����ϴ� ����� �̷������ �κ�
		else if(command.equals("/boardDeletePro.bo")) {
			action = new BoardDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		// �̵���η� �̵�
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
