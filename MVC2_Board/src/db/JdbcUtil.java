package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {

	private static Connection con = null;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/mvc2_db?serverTimezone=UTC&useSSL=false";
	private static String uid = "root";
	private static String upw = "1234";
	
	// Connection을 얻는 메서드
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			con.setAutoCommit(false); // 자동 commit 방지
			System.out.println("커넥션 성공");
		} catch (Exception e) { e.printStackTrace(); }
		return con;
	}
	
	// Connection리소스를 닫는 메서드
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Statement 리소스를 닫는 메서드
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// preparedStatement리소스를 닫는 메서드
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Resultset 리소스를 닫는 메서드
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 물리적 DB에 해당하는 commit 메소드
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
