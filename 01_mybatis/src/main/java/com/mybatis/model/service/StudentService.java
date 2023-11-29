package com.mybatis.model.service;

import static com.mybatis.common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

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
	
	public int selectStudentCount() {
		
		SqlSession session = getSession();
		int count = dao.selectStudentCount(session);
		session.close();
		return count;
		
	}
	
	public Student searchStudentByNo(int no) {
		SqlSession session = getSession();
		Student s = dao.searchStudentByNo(session, no);
		session.close();
		return s;
	}
	
	public List<Student> selectStudentAll(){
		SqlSession session = getSession();
		List<Student> students = dao.selectStudentAll(session);
		session.close();
		return students;
		
	}
	
	public List<Student> searchByName(String name){
		SqlSession session = getSession();
		List<Student> students = dao.searchByName(session, name);
		session.close();
		return students;
	}
	
	public Map searchStudentByNoMap(int no) {
		SqlSession session = getSession();
		Map result = dao.searchStudentByNoMap(session, no);
		session.close();
		return result;
		
	}
	
	public List<Map> searchAllMap() {
		SqlSession session = getSession();
		List<Map> result = dao.searchAllMap(session);
		session.close();
		return result;
	}
	
	public int insertMap(Map data) {
		SqlSession session = getSession();
		int result = dao.insertMap(session, data);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public List<Student> selectStudentPage(int cPage, int numPerpage){
		SqlSession session = getSession();
		List<Student> result = dao.selectStudentPage(session, cPage, numPerpage);
		session.close();
		return result;
	}
}
