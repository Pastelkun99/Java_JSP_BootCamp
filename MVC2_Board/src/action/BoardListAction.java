package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

// 게시글들을 가져오는 명령을 수행하는 커맨드 객체
public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		
		int page = 1;		// 페이지 번호
		int limit = 10;		// 한번에 표시할 페이지 번호를 저장
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardlistservice = new BoardListService();
		int listCount = boardlistservice.getListCount();				// 총 리스트 수를 받아옴
		articleList = boardlistservice.getArticleList(page, limit);		// 리스트를 받아옴.
		
		// 총 페이지 수
		// 0.95를 더해서 올림 처리, 총 페이지 수
		int maxPage = (int)((double)listCount/limit + 0.95);
		
		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등)
		int startPage = (((int) ((double)page/10 + 0.9)) -1) * 10 + 1;
		
		// 현재 페이지에 보여줄 마지막 페이지 수 (10, 20, 30 등)
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
		
		// 이동 경로를 지정하고 있다.
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");
		
		return forward;
	}

}
