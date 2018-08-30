package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.Dao;
import com.java.Employee;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * service method to update the details of given employee in database
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String oldEmail = request.getParameter("oldEmail");
	    Dao dao = new Dao();
	    
	    Employee updateEmp = new Employee(request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email"), Integer.parseInt(request.getParameter("age")));
	    if(dao.updateEmployee(updateEmp, oldEmail))
	        out.print("<script>alert(\"successfully updated!\")</script>");
	    else
	        out.print("<script>alert(\"ERROR!\")</script>");
	    
	    request.getRequestDispatcher("ShowEmployees").include(request, response);
	}

	
	/**
     * service method to update the details of given employee in database
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
