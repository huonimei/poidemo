package poidemo.poidemos;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Conn2mysql {
	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "root";
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
