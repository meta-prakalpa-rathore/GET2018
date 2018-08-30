package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.Dao;
import com.java.Employee;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {

	/**
	 * service method to add the employee details to the database
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
	    Dao dao = new Dao();
	    PrintWriter out = response.getWriter();
	    
	    String firstName = request.getParameter("firstname");
	    String lastName = request.getParameter("lastname");
	    String email = request.getParameter("email");
	    int age = Integer.parseInt(request.getParameter("age"));
	    
	    if(dao.addEmployee(new Employee(firstName, lastName, email, age)))
	        out.println("<script>alert(\"successfully added!\")</script>");
	    else
	        out.println("<script>alert(\"ERROR!\")</script>");
	    
	    request.getRequestDispatcher("index.html").include(request, response);
	    out.close();
	    
	}

	/**
     * service method to add the employee details to the database
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
