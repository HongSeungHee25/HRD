package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleUtility {

	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "iclass";
		String password = "0419";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 및 사용에 문제가 생겼습니다. : "+ e.getMessage());
		}
		return conn;
	}
	
	public static void close(Connection conn) throws ClassNotFoundException{
		try {
			if(conn != null) {
				conn.close();
			}else {
				System.out.println("Connection 이 null 입니다.");
			}
		}catch(SQLException e) {
			System.out.println("데이터베이스 연결 종료 오류 : "+e.getMessage());
		}
	}
	
}
