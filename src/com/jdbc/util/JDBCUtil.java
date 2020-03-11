package com.jdbc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
	public static DataSource ds = null;

	static {
		try {
			// 加载配置文件
			Properties p = new Properties();
			FileInputStream in = new FileInputStream("resource/db.properties");
			p.load(in);
			//ds = (BasicDataSource) DruidDataSourceFactory.createDataSource(p);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConn() {

		try {
			// 连接数据库
			return ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// 释放资源
	public static void close(Connection conn, Statement st, ResultSet res) {
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
