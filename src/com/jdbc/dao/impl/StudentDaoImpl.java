package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		PreparedStatement ps = null;

		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into student(name,age) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			System.out.println(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
	}

	@Override
	public void updata(int id, Student stu) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = JDBCUtil.getConn();
			String sql = "update student set name = ?,age = ? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setInt(3, id);
			System.out.println(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}

	}

	@Override
	public void delete(int id) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = JDBCUtil.getConn();
			String sql = "delete from student where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			System.out.println(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}

	}

	@Override
	public Student get(int id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from student where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			res = ps.executeQuery();
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
				JDBCUtil.close(conn, ps, res);
		}
		return null;
	}

	@Override
	public List<Student> getAll() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from student";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			res = ps.executeQuery();
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
			JDBCUtil.close(conn, ps, res);
		}
		return null;
	}
}
