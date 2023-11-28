package com.mybatis.model.service;

import static com.mybatis.common.SqlSessionTemplate.getSession;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.StudentDao;
import com.mybatis.model.dto.Student;

public class StudentService {

	private StudentDao dao=new StudentDao();
	
	public int insertStudent(Student s) {
		SqlSession session = getSession();
		int result = dao.insertStudent(session,s);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public int insertStudentName(String name) {
		SqlSession session = getSession();
		int result = dao.insertStudentName(session, name);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentObject(Student s) {
		SqlSession session = getSession();
		int result = dao.insertStudentObject(session, s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int updateStudent(Student s) {
		SqlSession session = getSession();
		int result = dao.updateStudent(session, s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int deleteStudent(int studentNo) {
		SqlSession session = getSession();
		int result = dao.deleteStudent(session, studentNo);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
}
