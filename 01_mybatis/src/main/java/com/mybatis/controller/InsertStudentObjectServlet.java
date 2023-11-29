package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.dto.Student;
import com.mybatis.model.service.StudentService;

/**
 * Servlet implementation class InsertStudentObject
 */
@WebServlet("/student/insertStudentObject.do")
public class InsertStudentObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudentObjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		Student s = Student.builder()
								.studentName(name)
								.studentTel(phone)
								.studentEmail(email)
								.studentAddress(address)
								.build();
				
		int result = new StudentService().insertStudentObject(s);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result>0?"<h2>입력성공</h2>":"<h2>입력실패</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
