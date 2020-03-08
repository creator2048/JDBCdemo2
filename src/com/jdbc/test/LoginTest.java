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
		// �������ݿ�
		Connection conn = JDBCUtil.getConn();
		// �鿴�û������룬��������ȷ
		String sql = "select * from user where name = ? and pwd = ?";
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, pwd);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			JDBCUtil.close(conn, ps, res);
			return "����ɹ�";
		} else {
			JDBCUtil.close(conn, ps, res);
			return "����ʧ��";
		}

	}

}
