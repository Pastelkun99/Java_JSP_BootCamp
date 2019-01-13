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
	
	// 생성자, 드라이버 코드
	public MemberDAO() {
		System.out.println("생성자");
	}
	
	// DBCP에서 커넥션 얻기
	public Connection getConnection() {
		try {
			ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbtool");
			con = dataSource.getConnection();
			System.out.println("DBCP 커넥션 얻어오기 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// 반환형이 ArrayList<MemberDTO>이다.
	public ArrayList<MemberDTO> memberSelect() {
		System.out.println("memberSelect 진입");
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		try {
			// DB 커넥션 및 쿼리문 실행
			// con = DriverManeger.getConnection(url, uid, upw);
			System.out.println("쿼리문 받아옴");
			// 서버에 있는 DB 커넥션 객체 사용
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
