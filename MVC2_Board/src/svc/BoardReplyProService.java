package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class BoardReplyProService {

	public boolean replyArticle(BoardBean bean) throws Exception {
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		// 답변글을 DAO객체를 이용해 DB에 등록하기위해 insertReplyArticle()를 호출하고 있다.
		insertCount = boardDAO.insertReplyArticle(bean);
		
		if(insertCount > 0) {
			commit(con);
			isReplySuccess = true;
		}
		else {
			rollback(con);
		}
		close(con);
		return isReplySuccess;
	}
}
