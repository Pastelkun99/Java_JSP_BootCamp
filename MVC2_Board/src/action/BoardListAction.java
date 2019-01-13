package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

// �Խñ۵��� �������� ����� �����ϴ� Ŀ�ǵ� ��ü
public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		
		int page = 1;		// ������ ��ȣ
		int limit = 10;		// �ѹ��� ǥ���� ������ ��ȣ�� ����
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardlistservice = new BoardListService();
		int listCount = boardlistservice.getListCount();				// �� ����Ʈ ���� �޾ƿ�
		articleList = boardlistservice.getArticleList(page, limit);		// ����Ʈ�� �޾ƿ�.
		
		// �� ������ ��
		// 0.95�� ���ؼ� �ø� ó��, �� ������ ��
		int maxPage = (int)((double)listCount/limit + 0.95);
		
		// ���� �������� ������ ���� ������ �� (1, 11, 21 ��)
		int startPage = (((int) ((double)page/10 + 0.9)) -1) * 10 + 1;
		
		// ���� �������� ������ ������ ������ �� (10, 20, 30 ��)
		int endPage = startPage + 10 - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		
		// �̵� ��θ� �����ϰ� �ִ�.
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");
		
		return forward;
	}

}
