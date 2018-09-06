package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.Dao;
import com.java.Employee;

/**
 * Servlet implementation class SearchEmployee
 */
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * service method to search employees by the given name from the database
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Dao dao = new Dao();
        List<Employee> listOfEmployees = dao.searchEmployees(request.getParameter("name"));
        
        out.print("<html><body>");
        out.print("<table>");
        out.print("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Age</th></tr>");
        
        for(Employee emp: listOfEmployees)
        {
            out.print("<tr><td>" + emp.getFirstName() + "</td><td>" + emp.getLastName() + "</td><td>" + emp.getEmail() + "</td><td>" + emp.getAge() + "</td></tr>");
        }
        out.print("</table>");
        out.print("</body></html>");
        out.close();
	}

	/**
     * service method to search employees by the given name from the database
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    doGet(request, response);
	}

}
