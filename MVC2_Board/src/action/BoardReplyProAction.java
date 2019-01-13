package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardReplyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		BoardBean bean = new BoardBean();
		bean.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
		bean.setBOARD_NAME(request.getParameter("BOARD_NAME"));
		bean.setBOARD_PASS(request.getParameter("BOARD_PASS"));
		bean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		bean.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
		bean.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
		bean.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
		bean.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
		
		BoardReplyProService boardReplyProService = new BoardReplyProService();
		
		boolean isReplySuccess = boardReplyProService.replyArticle(bean);
		
		if(isReplySuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo?page=" + nowPage);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
