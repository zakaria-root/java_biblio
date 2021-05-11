package com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.db.Student;
import com.util.db.StudentManager;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Connection")
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StudentManager sm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Connection#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		sm= new StudentManager();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		   String lg=request.getParameter("login");
		   String ps=request.getParameter("password");
		   Student s=sm.authentification(lg, ps);
		   if(s != null)
		   {
			   HttpSession ses = request.getSession(true);
			   
			   
			   ses.setAttribute("student", s);
			   
			   response.sendRedirect("index.jsp");
		   }else
			  
			   {
			   	response.sendRedirect("auth.jsp?res=err");
			   }
			
		
	}

}
