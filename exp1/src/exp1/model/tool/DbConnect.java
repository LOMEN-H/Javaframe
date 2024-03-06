package exp1.model.tool;

import java.sql.*;

public class DbConnect {
	public static Connection conn;

	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exp1", "root", "123456");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	public static void main(String args[]) {
		System.out.println(DbConnect.getConnect());
	}

}
