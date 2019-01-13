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
		
		//글쓴이가 맞는지 확인하는 부분
		boolean isArticleWriter = boardDeleteProService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"));
		
		// 글쓴이가 아니라면? (비밀번호 불일치)
		if(!isArticleWriter) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		// 글쓴이가 맞다면?
		else {
			// 삭제하는 부분
			boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);
			// 삭제에 실패했다면
			if(!isDeleteSuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			// 삭제 성공했다면 경로 지정후 경로를 리턴함
			else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo?page=" + nowPage);
			}
		}
		return forward;
	}

}
