package com.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.jdbc.util.JDBCUtil;

public class TransactionTest {
	public static void main(String[] args) throws Exception {
		
		Connection conn = JDBCUtil.getConn();
		//检查用户1余额
		String sql = "select * from account where name = ? and money > ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "Jack");
		ps.setInt(2, 1000);
		ResultSet res = ps.executeQuery();
		if (!res.next()) {
			throw new RuntimeException("没钱了");
		}
		try {
			//开启事务
			conn.setAutoCommit(false);
			//减少用户1	1000
			sql = "update account set money = money - ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, 1000);
			ps.setString(2,"Jack");
			ps.executeUpdate();
			//增加用户2	1000
			sql = "update account set money = money + ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, 1000);
			ps.setString(2,"Anne");
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			JDBCUtil.close(conn, ps, res);
		}
		
		
		
	}
}
