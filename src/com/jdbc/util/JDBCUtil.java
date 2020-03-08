package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static String url = "jdbc:mysql://localhost:3306/jdbc_db?serverTimezone=UTC";
	public static String user = "root";
	public static String password = "root";
	public static String DriverName = "com.mysql.jdbc.Driver";
	
	static {
		
		try {
			Class.forName(DriverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		
		try {
			//加载驱动
			Class.forName(JDBCUtil.DriverName);
			//连接数据库
			return DriverManager.getConnection(JDBCUtil.url, JDBCUtil.user, JDBCUtil.password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//释放资源
	public static void close(Connection conn,Statement st,ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}


