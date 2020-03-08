package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.IStudentDao;
import com.jdbc.domain.Student;
import com.jdbc.util.JDBCUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public void save(Student stu) {
		Connection conn = null;
		Statement st = null;

		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			String sql = "insert into student(name,age) values('" + stu.getName() + "'," + stu.getAge() + ")";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, st, null);
		}
	}

	@Override
	public void updata(int id, Student stu) {

		Connection conn = null;
		Statement st = null;

		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			String sql = "update student set name = '" + stu.getName() + "',age = " + stu.getAge() + " where id=" + id
					+ "";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, st, null);
		}

	}

	@Override
	public void delete(int id) {

		Connection conn = null;
		Statement st = null;

		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			String sql = "delete from student where id = " + id + "";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, st, null);
		}

	}

	@Override
	public Student get(int id) {

		Connection conn = null;
		Statement st = null;
		ResultSet res = null;

		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			String sql = "select * from student where id = " + id + "";
			System.out.println(sql);
			res = st.executeQuery(sql);
			if (res.next()) {
				Student stu = new Student();
				stu.setName(res.getString("name"));
				stu.setAge(res.getInt("age"));
				stu.setId(res.getInt("id"));
				return stu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				JDBCUtil.close(conn, st, res);
		}
		return null;
	}

	@Override
	public List<Student> getAll() {

		Connection conn = null;
		Statement st = null;
		ResultSet res = null;

		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			String sql = "select * from student";
			System.out.println(sql);
			res = st.executeQuery(sql);
			List<Student> list = new ArrayList<Student>();
			while (res.next()) {
				Student stu = new Student();
				stu.setName(res.getString("name"));
				stu.setAge(res.getInt("age"));
				stu.setId(res.getInt("id"));
				list.add(stu);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, st, res);
		}
		return null;
	}
}
