package com.jdbc.dao;

import java.util.List;

import com.jdbc.domain.Student;

public interface IStudentDao {
	//��������
	void save(Student stu);
	//�޸�ָ��ѧ����Ϣ
	void updata(int id,Student stu);
	
	//ɾ��ѧ��
	void delete(int id);
	//��ѯ����ѧ��
	Student get(int id);
	//��ѯָ��ѧ��
	List<Student> getAll();
	
}
