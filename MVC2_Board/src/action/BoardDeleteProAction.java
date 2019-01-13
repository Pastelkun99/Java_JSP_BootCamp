package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDeleteProService;
import vo.ActionForward;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String nowPage = request.getParameter("page");
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		
		//�۾��̰� �´��� Ȯ���ϴ� �κ�
		boolean isArticleWriter = boardDeleteProService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"));
		
		// �۾��̰� �ƴ϶��? (��й�ȣ ����ġ)
		if(!isArticleWriter) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('������ ������ �����ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		// �۾��̰� �´ٸ�?
		else {
			// �����ϴ� �κ�
			boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);
			// ������ �����ߴٸ�
			if(!isDeleteSuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('��������');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			// ���� �����ߴٸ� ��� ������ ��θ� ������
			else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo?page=" + nowPage);
			}
		}
		return forward;
	}

}
