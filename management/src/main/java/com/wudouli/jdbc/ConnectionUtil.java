package com.wudouli.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public Connection getConnection() {

		Connection conn = null;

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/GUESTBOOK";
		String user = "caterpillar";
		String password = "123456";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null && !conn.isClosed()) {
				System.out.println("資料庫連線測試成功！");
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驅動程式類別");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
