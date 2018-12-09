package Apk;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
	public static void main(String[] args) {
	ConnectionDb koneksi = new ConnectionDb();
	Connection connection = (Connection) koneksi.getConnection();
	}
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectbank", "root", "");
		}catch(Exception e) {
			
		}
		return connection;
	}
	}

