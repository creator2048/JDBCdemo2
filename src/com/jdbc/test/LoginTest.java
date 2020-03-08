package com.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.jdbc.util.JDBCUtil;

public class LoginTest {

	@Test
	public void Test() throws Exception {
		System.out.println(this.login("Jack", "1234"));
		
	}
	
	String login(String userName, String pwd) throws Exception {
		// 连接数据库
		Connection conn = JDBCUtil.getConn();
		// 查看用户名传入，且密码正确
		String sql = "select * from user where name = ? and pwd = ?";
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, pwd);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			JDBCUtil.close(conn, ps, res);
			return "登入成功";
		} else {
			JDBCUtil.close(conn, ps, res);
			return "登入失败";
		}

	}

}
