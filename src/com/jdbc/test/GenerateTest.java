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
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "����");
		ps.setInt(2, 23);
		
		//���ÿ��Ի�ȡ����
		ps.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		//��ȡ�Զ����ɵ�id
		ResultSet res = ps.getGeneratedKeys();
		if (res.next()) {
			int id = res.getInt(1);
			System.out.println(id);
		}
		JDBCUtil.close(conn, ps, null);
		
		
		
	}
	
	void test() throws Exception {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student(name,age) values ('����',25) ";
		Statement st = conn.createStatement();
		//���ÿ��Ի�ȡ����
		st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		//��ȡ�Զ����ɵ�id
		ResultSet res = st.getGeneratedKeys();
		if (res.next()) {
			int id = res.getInt(1);
			System.out.println(id);
		}
		JDBCUtil.close(conn, st, null);
		
	}
}
