package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// boardnum�� page��ȣ�� request�κ��� �޴´�.
		BoardDetailService boardDetailService = new BoardDetailService();
		String board_num = request.getParameter("board_num");
		String page = request.getParameter("page");
		int board_num_convert = Integer.parseInt(board_num);
		BoardBean bean = boardDetailService.getArticle(board_num_convert);
		
		// BoardDetailServiceŬ������ �����, �������ϴ� �Խñ��� ������ ���� board_num���� ���ڰ��� �־� getArticle()ȣ���ϰ�
		// �׿� ���� �Խñ� ������ ���Ϲް� �ִ�.
		request.setAttribute("BoardBean", bean);
		System.out.println("board_num : " + board_num);
		System.out.println("page : " + page);
		
		// request��ü���ٰ� page��ȣ�� �Խñ��� setter�� ȣ���Ͽ� �����ϰ� �ִ�.
		request.setAttribute("page", page);
		request.setAttribute("bean", bean);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_view.jsp");
		
		return forward;
	}

}
