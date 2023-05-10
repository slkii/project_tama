package Mainpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class DS_DAO {

	private Connection conn;
	PreparedStatement pst= null;
	ResultSet rs;
	public void connect() {
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //JAR 8

		String url = "jdbc:oracle:thin:@211.228.36.134:1521:xe";
		String user = "C##PROJECT";
		String password = "12345";

		conn = DriverManager.getConnection(url, user, password);

		if (conn == null) {
			System.out.println("연결실패");
		} 
		
	} catch (Exception e) {

		e.printStackTrace();
	}

	}
		
	
	
	public int Signup(String id, String password) { //회원가입
		
		connect();
		
		String signup = "insert into DeveloperID values (?, ?)";
		
		try {
			pst = conn.prepareStatement(signup);
			
			pst.setString(1, id);
			pst.setString(2, password);
			
			int cnt = pst.executeUpdate();
			
			return cnt;
		}catch(SQLIntegrityConstraintViolationException e){ // 회원가입탭 중복id 출력시 오류메시지 예외시키기
			
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return 0;
}
	public int Signup_delete(String id) { //회원탈퇴
		connect();
		
		String del = "delete from DeveloperID where id = ?";
		
		try {
			pst = conn.prepareStatement(del);
			
			pst.setString(1, id);
			
			int cnt = pst.executeUpdate();
			
			return cnt;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int login (String id, String password) { //로그인
		connect();
		
		String log = "Select pw from DeveloperID where id=?";
		try {
			pst = conn.prepareStatement(log);
			pst.setString(1, id);
			
			rs = pst.executeQuery();
			if(rs.next()) { // 다음이 있는지 true/false로 반환
				if(rs.getString(1).contentEquals(password)) {
					return 1;
				}
				else {
					return 0;
				}
			}
			return -1; //존재하지 않는 아이디.
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	 //DB 오류
		return -2;
	}
	public void close(PreparedStatement pst, Connection conn, ResultSet rs) { //닫기
		try {
			if(pst != null){
				pst.close();
			}
			if(conn != null) {
				conn.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch(SQLException e)	{
			e.printStackTrace();
		}
	}
	

	}
	
	
	

