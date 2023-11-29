package com.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.dto.Student;
import com.mybatis.model.service.StudentService;

/**
 * Servlet implementation class PageStudentServlet
 */
@WebServlet("/student/pageStudent.do")
public class PageStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage=1 , numPerpage = 5;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
			
		}catch(NumberFormatException e) {
			/* e.printStackTrace(); */
		}
		
		try {
			numPerpage = Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e) {
			/* e.printStackTrace(); */
		}
		
		int totalData = new StudentService().selectStudentCount();
		int totalPage = (int)(Math.ceil((double)totalData/numPerpage));
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar="";
		
		List<Student> students = new StudentService().selectStudentPage(cPage,numPerpage);
	
		if(pageNo==1) {
			pageBar="<span>[이전]</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURI()
			+"?cPage="+(pageNo-1)
			+"&numPerpage="+numPerpage+"'>[이전]</a>";
			
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getRequestURI()
				+"?cPage="+(pageNo)
				+"&numPerpage="+numPerpage+"'>"+pageNo+"</a>";
			}
			
			pageNo++;
		}
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURI()
			+"?cPage="+(pageNo)
			+"&numPerpage="+numPerpage+"'>[다음]</a>";
		}
		
		request.setAttribute("students", students);
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/views/student/student.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
