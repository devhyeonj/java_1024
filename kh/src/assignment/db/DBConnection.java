package assignment.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	private static ConnectionConst con;
	private static Connection connection;
	
	// 데이터베이스 연결
	public static Connection getConnection(){
		try {
			connection = DriverManager.getConnection(con.URL,con.USERNAME,con.PASSWORD);
		} catch (SQLException e) {
			System.out.println("에러: " + e);
	}
		return connection;

}
}