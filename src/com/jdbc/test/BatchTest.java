package com.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.util.JDBCUtil;

public class BatchTest {
	public static void main(String[] args) throws Exception {
		
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student (name,age) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			ps.setString(1, "Jack");
			ps.setInt(2, 12);
			ps.addBatch();
		}
		//执行批处理
		ps.executeBatch();
		long end = System.currentTimeMillis();
		long time = end - begin;
		
		System.out.println(time);
		
		JDBCUtil.close(conn, ps, null);
		
		
	}
}
