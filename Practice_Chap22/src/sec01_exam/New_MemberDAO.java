package sec01_exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class New_MemberDAO {

	// DAO��ü�� Database Access Object��.
	// �� �����ͺ��̽��� �����Ͽ� ��ȸ, ����, ���� ���� �۾��� �����ϴ� ��ü�̴�.
	// �׸��� ������� �޾ƿ´�. �� �� �߱��������� �����͸� �޾ƿ��� ���� �ƴ϶� DTO��ü�� �޾ƿ� �� �ֵ��� �����ش�.
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/sqldb";
	private String uid = "root";
	private String upw = "1234";
	
	// ������, ����̹� �ڵ�
	public New_MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) { e.printStackTrace(); }
	}
	
	// ��ȯ���� ArrayList<MemberDTO>�̴�.
	public ArrayList<New_MemberDTO> memberselect() {
		ArrayList<New_MemberDTO> dtos = new ArrayList<New_MemberDTO>();
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String query = "select * from new_member";
		try {
			// DBĿ�ؼ� �� ������ ����
			con = DriverManager.getConnection(url, uid, upw);
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			// DB���� ������ �����͸� �Ʒ��� ���� �޾Ƽ� MemberDTO�� ������ �Ű������� �����ϰ�,
			// �ƿ﷯ �� ��ü�� ArrayList<MemberDTO>�� ��� �߰��մϴ�.
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				New_MemberDTO dto = new New_MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
		} catch (Exception e) {e.printStackTrace();}
		// �� �߰��� ArrayList<MemberDTO> ��ü�� �����Ѵ�.
		return dtos;
	}
	
	public int memberInsert(New_MemberDTO dto) {
		Connection con = null;
		PreparedStatement psmt = null;
		String query = "insert into new_member values (?, ?, ?, ?, ?, ?, ?)";
		try {
			con = DriverManager.getConnection(url, uid, upw);
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());
			psmt.setString(4, dto.getPhone1());
			psmt.setString(5, dto.getPhone2());
			psmt.setString(6, dto.getPhone3());
			psmt.setString(7, dto.getGender());
			psmt.executeUpdate();
			System.out.println("��� ����");
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
}
