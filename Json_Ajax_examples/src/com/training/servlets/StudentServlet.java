package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entity.Student;
import com.training.services.StudentServiceImpl;
import com.training.utils.MyGsonParser;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out =response.getWriter();
		//response.setContentType("application/json");
		//String employee ="{'id':101 , 'name':'ramesh' }";
		//out.println("<h1>Using JSON</h1>");
		//out.println(employee);
		PrintWriter out = response.getWriter();
		String studentId = request.getParameter("studentId");
		StudentServiceImpl service = new StudentServiceImpl();
		 Student student = service.findById(Integer.parseInt(studentId));
		 response.setContentType("text/html");
		// System.out.println(student.getStudentName());
		 out.println(student.getStudentName());
		 
		 //MyGsonParser parser = new MyGsonParser();
		 //String jsonResp = parser.transformToGson(student);
		 //out.println(jsonResp);
		 
		 //HashMap<Integer,Student>list =service.findAll();
		 //String jsonResp1 = parser.transformToGson(list);
		 //out.println(jsonResp1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String strId = request.getParameter("studentId");
		String strName = request.getParameter("studentName");
		int id =Integer.parseInt(strId);
		StudentServiceImpl service = new StudentServiceImpl();
		Student student = service.findById(Integer.parseInt(strId));
		System.out.println(student);
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		MyGsonParser parser = new MyGsonParser();
		String jsonRes = parser.transformToGson(student);
		out.println(student);
		
		//request.setAttribute("id", id);
		//request.setAttribute("name",strName );
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/showStudent.jsp");
		//dispatcher.forward(request, response);
	}

}
