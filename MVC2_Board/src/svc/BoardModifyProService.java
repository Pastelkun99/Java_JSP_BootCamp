package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

public class BoardModifyProService {
	
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		
		// �Խù�ȣ�� �´� �۰� ����ڰ� �Է��� �н����带 ������ �Խñ��� �ۼ��� ������� Ȯ���ϴ� ��
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		// DAO��ü isArticleBoardWriter���� �ۼ��ڸ� Ȯ����
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con);
		return isArticleWriter;
	}
	
	// �Ѿ�� �Խñ��� ����
	public boolean modifyArticle(BoardBean bean) throws Exception {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		// DAO ��ü�� updateArticle()ȣ���ؼ� �۾� ����
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

