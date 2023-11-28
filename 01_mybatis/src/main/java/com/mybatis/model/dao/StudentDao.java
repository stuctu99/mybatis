package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dto.Student;

public class StudentDao {
	
	public int insertStudent(SqlSession session, Student s) {
		//mybatis에서 sql문을 실행하려면
		//SqlSession클래스가 제공하는 메소드를 이용한다.
		//DML(insert, update, delete) :
		//		insert("mapper명.sqlid"[,object]), update(), delete()
		//int result = session.insert("student.insertStudent");
		
		//DQL(select) : 
		//		selectOne()
		//		selectList()
		
		return session.insert("student.insertStudent");
	}
	
	public int insertStudentName(SqlSession session, String name) {
		return session.insert("student.insertStudentName",name);
		
	}
	
	public int insertStudentObject(SqlSession session, Student s) {
		return session.insert("student.insertStudentObject",s);
	}
	
	public int updateStudent(SqlSession session, Student s) {
		return session.update("student.updateStudent",s);
	}
	
	public int deleteStudent(SqlSession session, int studentNo) {
		return session.delete("student.deleteStudent",studentNo);
	}
}
