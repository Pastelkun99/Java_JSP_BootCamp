package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// boardnum과 page번호를 request로부터 받는다.
		BoardDetailService boardDetailService = new BoardDetailService();
		String board_num = request.getParameter("board_num");
		String page = request.getParameter("page");
		int board_num_convert = Integer.parseInt(board_num);
		BoardBean bean = boardDetailService.getArticle(board_num_convert);
		
		// BoardDetailService클래스를 만들고, 보고자하는 게시글을 위에서 받은 board_num으로 인자값을 주어 getArticle()호출하고
		// 그에 관한 게시글 내용을 리턴받고 있다.
		request.setAttribute("BoardBean", bean);
		System.out.println("board_num : " + board_num);
		System.out.println("page : " + page);
		
		// request객체에다가 page번호와 게시글을 setter를 호출하여 지정하고 있다.
		request.setAttribute("page", page);
		request.setAttribute("bean", bean);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_view.jsp");
		
		return forward;
	}

}
