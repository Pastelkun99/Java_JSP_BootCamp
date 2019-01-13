package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int board_num = Integer.parseInt(request.getParameter("BOARD_NUM"));
		String page = request.getParameter("page");
		BoardBean bean = new BoardBean();
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		
		// �� �ۼ��ڰ� �´��� Ȯ���ϴ� �κ�
		boolean isRightUser = boardModifyProService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"));
		
		// �� �ۼ��ڰ� �ƴ϶��?
		if(!isRightUser) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('������ ������ �����ϴ�')");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
			bean.setBOARD_NUM(board_num);
			bean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			bean.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			isModifySuccess = boardModifyProService.modifyArticle(bean);
			
			if(!isModifySuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('��������');");
				out.println("history.back()");
				out.println("</script>");
			}
			// ���� ���������� ��� ������ ������ �̵�
			else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num=" + bean.getBOARD_NUM() + "&page=" + page);
			}
		}
		return forward;
	}

}
