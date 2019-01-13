package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.BoardBean;
import static db.JdbcUtil.*;

// db�� �����Ͽ� ����� �����ϴ� Ŭ����
public class BoardDAO {

	DataSource ds;
	Connection con;
	
	private static BoardDAO boardDAO;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount ���� : " + e.toString());
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	//�� ���.
	@SuppressWarnings("resource")
	public int insertArticle(BoardBean article) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;
		
		try {
			// �Խ��� �Խñ��� �ֻ��� ��ȣ�� �������� ����
			pstmt = con.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();
			// ���� �ϳ��� �����Ѵٸ� �� ������ �ֻ��� ��ȣ���� +1�� �ؼ� num����
			if(rs.next()) {
				num = rs.getInt(1)+1;
				// ���� �ϳ��� ���ٸ�.. ���� ���� ���� �ݵ�� 1��° ���� �ǹǷ� num�� 1�� �����Ѵ�.
			} else {
				num = 1;
			}
			
			sql = "insert into board(BOARD_NUM, BOARD_NAME, BOARD_PASS,";
			sql += "BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());		// �ۼ���
			pstmt.setString(3, article.getBOARD_PASS());		// ��ȣ
			pstmt.setString(4, article.getBOARD_SUBJECT());		// ����	
			pstmt.setString(5, article.getBOARD_CONTENT());		// ����
			pstmt.setString(6, article.getBOARD_FILE());		// ÷������
			pstmt.setInt(7, num);					// ���� �۹�ȣ
			pstmt.setInt(8, 0);						// �亯�� ����
			pstmt.setInt(9, 0);						// �亯���� ��¼��� ���� column
			pstmt.setInt(10, 0); 					// �Խñ� ��ȸ��
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("boardInsert���� : " + e.toString());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	// �� ��� ����
	public ArrayList<BoardBean> selectArticleList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql = "select * from board order by BOARD_RE_REF desc, BOARD_RE_SEQ asc limit ?, 10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow = (page - 1) * 10; 	// �б� ������ row ��ȣ
		
		try {
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardBean();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				// boardbean �ϳ��� ��ü�� arraylist�� �߰��ϰ� �ִ�.
				articleList.add(board);
				
			}
		} catch (Exception e) {
			System.out.println("getBoardList ���� : " + e.toString());
		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	public int updateReadCount(int board_num) {
		
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update board set BOARD_READCOUNT = (BOARD_READCOUNT + 1) where BOARD_NUM = " + board_num);
			commit(con);
		} catch (Exception e) {
			System.out.println("updateReadCount ���� : " + e.toString());
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return board_num;
		
	}
	
	public BoardBean selectArticle(int board_num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean bean = new BoardBean();
		
		try {
			pstmt = con.prepareStatement("select * from board where BOARD_NUM = ?");
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				bean.setBOARD_NAME(rs.getString("BOARD_NAME"));
				bean.setBOARD_PASS(rs.getString("BOARD_PASS"));
				bean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				bean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				bean.setBOARD_FILE(rs.getString("BOARD_FILE"));
				bean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				bean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				bean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				bean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				bean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
			
			/*System.out.println("board_num : " + bean.getBOARD_NUM());
			System.out.println("board_name : " + bean.getBOARD_NAME());
			System.out.println("board_pass : " + bean.getBOARD_PASS());
			System.out.println("board_subject : " + bean.getBOARD_SUBJECT());
			System.out.println("board_content : " + bean.getBOARD_CONTENT());
			System.out.println("board_file : " + bean.getBOARD_FILE());
			System.out.println("board_re_ref : " + bean.getBOARD_RE_REF());
			System.out.println("board_re_lev : " + bean.getBOARD_RE_LEV());
			System.out.println("board_re_seq : " + bean.getBOARD_RE_SEQ());
			System.out.println("board_readcount : " + bean.getBOARD_READCOUNT());
			System.out.println("board_date : " + bean.getBOARD_DATE());*/
			
		} catch (Exception e) {
			System.out.println("��ü ȣ�� ����");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return bean;
	}

	@SuppressWarnings("resource")
	public int insertReplyArticle(BoardBean bean) {
		
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String board_max_sql = "select max(board_num) from board";
		String sql = "";
		int num = 0;
		int insertCount = 0;
		int re_ref = bean.getBOARD_RE_REF();
		int re_lev = bean.getBOARD_RE_LEV();
		int re_seq = bean.getBOARD_RE_SEQ();
		
		try {
			
			pstmt = con.prepareStatement(board_max_sql);
			set = pstmt.executeQuery();
			if(set.next()) {
				num = set.getInt(1)+1;
			}
			else {
				num = 1;
			}
			
			sql = "update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF = ? and BOARD_RE_SEQ = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			
			if(updateCount > 0) {
				commit(con);
			}
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
			sql = "insert into board(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, bean.getBOARD_NAME());
			pstmt.setString(3, bean.getBOARD_PASS());
			pstmt.setString(4, bean.getBOARD_SUBJECT());
			pstmt.setString(5, bean.getBOARD_CONTENT());
			pstmt.setString(6, ""); // ��ۿ��� ÷������ ����
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("boardreply ������Ʈ ���� : " + e.toString());
			e.printStackTrace();
		} finally {
			close(set);
			close(pstmt);
		}
		return insertCount;
	}

	public boolean isArticleBoardWriter(int board_num, String pass) {
		
		PreparedStatement pstmt = null;
		ResultSet set = null;
		
		boolean writer = false;
		String query = "select BOARD_PASS from board where BOARD_NUM = ?";
		String password = "";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, board_num);
			set = pstmt.executeQuery();
			
			while(set.next()) {
				password = set.getString("BOARD_PASS");
				System.out.println(password);
			}
			
			if(pass.equals(password)) {
				writer = true;
			}
			else {
				writer = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer;
	}

	public int updateArticle(BoardBean bean) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update board set BOARD_SUBJECT = ?, BOARD_CONTENT = ? where BOARD_NUM = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bean.getBOARD_SUBJECT());
			pstmt.setString(2, bean.getBOARD_CONTENT());
			pstmt.setInt(3, bean.getBOARD_NUM());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteArticle(int board_num) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from board where BOARD_NUM = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, board_num);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
