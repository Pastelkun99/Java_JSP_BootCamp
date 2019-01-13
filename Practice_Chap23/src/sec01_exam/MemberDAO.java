package sec01_exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private DataSource dataSource;
	protected Connection con = null;
	protected PreparedStatement psmt = null;
	protected ResultSet rs = null;
	protected Context ctx = null;
	
	// ������, ����̹� �ڵ�
	public MemberDAO() {
		System.out.println("������");
	}
	
	// DBCP���� Ŀ�ؼ� ���
	public Connection getConnection() {
		try {
			ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbtool");
			con = dataSource.getConnection();
			System.out.println("DBCP Ŀ�ؼ� ������ ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// ��ȯ���� ArrayList<MemberDTO>�̴�.
	public ArrayList<MemberDTO> memberSelect() {
		System.out.println("memberSelect ����");
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		try {
			// DB Ŀ�ؼ� �� ������ ����
			// con = DriverManeger.getConnection(url, uid, upw);
			System.out.println("������ �޾ƿ�");
			// ������ �ִ� DB Ŀ�ؼ� ��ü ���
			// con = dataSource.getConnection();
			Connection con = this.getConnection();
			String query = "select * from new_member";
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				MemberDTO dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
}
