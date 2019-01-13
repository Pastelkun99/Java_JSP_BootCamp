package svc;

import dao.BoardDAO;
import static db.JdbcUtil.*;

import java.sql.Connection;

public class BoardDeleteProService {

	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con);
		
		return isArticleWriter;
	}

	public boolean removeArticle(int board_num) throws Exception {
		
		boolean isDeleteSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.deleteArticle(board_num);
		
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isDeleteSuccess;
	}

}
