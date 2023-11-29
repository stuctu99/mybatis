package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dto.Student;

public class StudentDao {
	
	public int insertStudent(SqlSession session, Student s) {
		//mybatis에서 sql문을 실행하려면
		//SqlSession클래스가 제공하는 메소드를 이용한다.
		//DML(insert, update, delete) :
		//		insert("mapper명.sqlId"[,object]), update(), delete()
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
	
	public int selectStudentCount(SqlSession session) {
		//select메소드 
		//	selectOne : select문의 결과가 0~1개일 경우 사용하는 메소드
		//	selectList : select문의 결과가 0~1개 이상일 경우 사용하는 메소드 
		//	selectOne("mapper명.sqlId"[,Object]) 매개변수 
		//selectList("mapper명.sqlId"[,Object,RowBounds]) 
		return session.selectOne("student.selectStudentCount");
	}
	
	public Student searchStudentByNo(SqlSession session, int no) {
		return session.selectOne("student.searchStudentByNo",no);
	}
	
	public List<Student> selectStudentAll(SqlSession session){
		return session.selectList("student.selectStudentAll");
	}
	
	public List<Student> searchByName(SqlSession session, String name){
		return session.selectList("student.searchByName", name);
	}
	
	public Map searchStudentByNoMap(SqlSession session, int no) {
		return session.selectOne("student.searchStudentByNoMap",no);
	}
	
	public List<Map> searchAllMap(SqlSession session) {
		return session.selectList("student.searchAllMap");
	}
	
	public int insertMap(SqlSession session, Map data) {
		return session.insert("student.insertMap",data);
	}
	
	public List<Student> selectStudentPage(SqlSession session, int cPage, int numPerpage){
		//mybatis에서 페이징 처리할 때 
		//RowBounds 클래스를 이용해서 처리한다.
		//selectList("sql",object, RowBounds)
		//RowBounds는 매개변수 있는 생성자로 객체를 생성함
		//	1 : offset : 시작 row번호 -> (cPage-1)*numPerpage
		//	2 : limit(간격) : numPerpage
		RowBounds rb = new RowBounds((cPage-1)*numPerpage,numPerpage);
		return session.selectList("student.selectStudentPage",null,rb);
		
	}
}
