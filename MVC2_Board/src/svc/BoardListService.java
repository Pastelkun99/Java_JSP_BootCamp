package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

public class BoardListService {

	// ÃÑ °Ô½Ã±ÛÀÇ °¹¼ö¸¦ °¡Á®¿È.
	public int getListCount() throws Exception {

		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		close(con);
		
		return listCount;
	}
	
	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception {
		
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page, limit);
		close(con);
		return articleList;
	}
}
