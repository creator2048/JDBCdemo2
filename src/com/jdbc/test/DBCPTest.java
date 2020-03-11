package com.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPTest {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc_db?serverTimezone=UTC";
		String user = "root";
		String password = "root";
		String DriverName = "com.mysql.jdbc.Driver";
		
		
		BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName(DriverName);
	    ds.setUsername(user);
	    ds.setPassword(password);
	    ds.setUrl(url);
	    
	    Connection conn = ds.getConnection();
	    
	    
	}
	
}
