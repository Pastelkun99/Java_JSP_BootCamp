package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

public class BoardModifyProService {
	
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		
		// 게시번호에 맞는 글과 사용자가 입력한 패스워드를 가지고 게시글을 작성한 사람인지 확인하는 것
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		// DAO객체 isArticleBoardWriter에서 작성자를 확인함
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con);
		return isArticleWriter;
	}
	
	// 넘어온 게시글을 수정
	public boolean modifyArticle(BoardBean bean) throws Exception {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		// DAO 객체의 updateArticle()호출해서 작업 수행
		int updateCount = boardDAO.updateArticle(bean);
		
		if(updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		}
		else {
			rollback(con);
		}
		close(con);
		
		return isModifySuccess;
	}
}

