package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

public class BoardDetailService {

	public BoardBean getArticle(int board_num) throws Exception {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		BoardBean bean = new BoardBean();
		bean = boardDAO.selectArticle(board_num);
		int updateCount = boardDAO.updateReadCount(board_num);
		close(con);
		
		/*if(updateCount > 0) {
			commit(con);
		}
		else {
			rollback(con);
		}*/
		
		return bean;
	}
}
