package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;

import dao.BoardDAO;
import vo.BoardBean;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception {
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		
		// DAO인스턴스를 가져오고 있다.(싱글톤)
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(boardBean);
		
		// 게시글이 등록되었다면
		if(insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		}
		// 등록되지 않았다면
		else {
			rollback(con);	//롤백해라
		}
		
		close(con);
		return isWriteSuccess;
	}
}
