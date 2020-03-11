package com.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.JDBCUtil;

public class GenerateTest {
	public static void main(String[] args) throws Exception {
	
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student(name,age) values(?,?) ";	
		//设置可以获取主键	
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "李四");
		ps.setInt(2, 23);
		ps.executeUpdate();
		//获取自动生成的id
		ResultSet res = ps.getGeneratedKeys();
		if (res.next()) {
			int id = res.getInt(1);
			System.out.println(id);
		}
		JDBCUtil.close(conn, ps, null);
		
		
		
	}
	
	void test() throws Exception {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student(name,age) values ('张三',25) ";
		Statement st = conn.createStatement();
		//设置可以获取主键
		st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		//获取自动生成的id
		ResultSet res = st.getGeneratedKeys();
		if (res.next()) {
			int id = res.getInt(1);
			System.out.println(id);
		}
		JDBCUtil.close(conn, st, null);
		
	}
}
