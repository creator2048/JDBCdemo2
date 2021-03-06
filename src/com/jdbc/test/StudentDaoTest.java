package com.jdbc.test;

import java.util.List;

import org.junit.Test;

import com.jdbc.dao.IStudentDao;
import com.jdbc.dao.impl.StudentDaoImpl;
import com.jdbc.domain.Student;

public class StudentDaoTest {
	public static void main(String[] args) {
		
	}
	
	@Test
	public void save() {
		Student stu = new Student();
		stu.setName("Tom");
		stu.setAge(15);
		
		IStudentDao dao = new StudentDaoImpl();
		dao.save(stu);
	}
	
	@Test
	public void update() {
		Student stu = new Student();
		stu.setName("Mary2");
		stu.setAge(20);
		
		IStudentDao dao = new StudentDaoImpl();
		dao.updata(2, stu);
	}
	
	@Test
	public void delete() {
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(4);
	}
	
	@Test
	public void get() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = dao.get(3);
		System.out.println(stu);
	}
	
	@Test
	public void getAll() {
		IStudentDao dao = new StudentDaoImpl();
		List<Student> allStu = dao.getAll();
		System.out.println(allStu);
	}
	
}
