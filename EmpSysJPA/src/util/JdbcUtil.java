package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {
	
	
	public JdbcUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		
//		String hostName = "127.0.0.1";
//		String dbName = "antra";
//		String userName ="root";
//		String password = "1234";
		
//		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		String connectionURL = "jdbc:mysql://localhost:3306/antra";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connectionURL, "root", "1234");
//		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		
		return conn;
	}

}
