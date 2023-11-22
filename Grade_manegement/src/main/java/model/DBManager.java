package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBManager {

	private static DBManager instance = new DBManager();
	private DBManager() {};
	public static DBManager getDbManager() {
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "iclass";
		String pw = "0419";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
}
