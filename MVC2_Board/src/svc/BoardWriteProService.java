package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;

import dao.BoardDAO;
import vo.BoardBean;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception {
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		
		// DAO�ν��Ͻ��� �������� �ִ�.(�̱���)
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(boardBean);
		
		// �Խñ��� ��ϵǾ��ٸ�
		if(insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		}
		// ��ϵ��� �ʾҴٸ�
		else {
			rollback(con);	//�ѹ��ض�
		}
		
		close(con);
		return isWriteSuccess;
	}
}
