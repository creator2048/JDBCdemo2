package com.jdbc.dao;

import java.util.List;

import com.jdbc.domain.Student;

public interface IStudentDao {
	//保存数据
	void save(Student stu);
	//修改指定学生信息
	void updata(int id,Student stu);
	
	//删除学生
	void delete(int id);
	//查询所有学生
	Student get(int id);
	//查询指定学生
	List<Student> getAll();
	
}
