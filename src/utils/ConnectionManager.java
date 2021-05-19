package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static String URL = "jdbc:mysql://localhost:3306/myshop";
	private static String USR = "root";
	private static String PWD = "lwin";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USR,PWD);
	}

}
