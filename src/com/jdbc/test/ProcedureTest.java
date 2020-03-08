package com.jdbc.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.domain.Student;
import com.jdbc.util.JDBCUtil;

public class ProcedureTest {
	public static void main(String[] args) throws Exception {
		
		Connection conn = JDBCUtil.getConn();
		CallableStatement cs = conn.prepareCall("{call getStu(?)}");
		cs.setString(1, "Bill");
		ResultSet res = cs.executeQuery();
		if(res.next()) {
			Student stu = new Student();
			stu.setId(res.getInt("id"));
			stu.setName(res.getString("name"));
			stu.setAge(res.getInt("age"));
			System.out.println(stu);
		
		}
		
	}
}
