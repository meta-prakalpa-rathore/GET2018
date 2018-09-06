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
 * Servlet implementation class ShowEmployees
 */
public class ShowEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	/**
	 * service method to show all the employees
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    Dao dao = new Dao();
	    List<Employee> listOfEmployees = dao.getAllEmployees();
	
	    out.print("<html><head>");
	    out.print("<link href='styling.css' rel='stylesheet'></link></head>");
	    out.print("<body>");
	    out.print("<br/> <br/>");
        out.print("<h1>Employee details</h1>");
        out.print("<br/> <br/>");
	    out.print("<table class='form-style-1'>");
	    out.print("<tr><th>First Name</th><th></th><th>Last Name</th><th></th><th>Email</th><th></th><th>Age</th></tr>");
	    out.print("<tr><td><br/></td></tr>");
	    
	    for(Employee emp: listOfEmployees)
	    {
	        out.print("<tr><td>" + emp.getFirstName() + "</td><td></td><td>" + emp.getLastName() + "</td><td></td><td>" + emp.getEmail() + "</td><td></td><td>" + emp.getAge() + "</td><td></td>");
	        out.print("<td><a href='UpdateEmployee?email=" + emp.getEmail() + "&fname=" + emp.getFirstName() + "&lname=" + emp.getLastName() + "&age=" + emp.getAge() + "'>Edit</a></td></tr>");
	        out.print("<tr><td><br/></td></tr>");
	    }
	    
	    out.print("</table>");
	    out.print("</body></html>");
	    out.close();
	}

	
	/**
     * service method to show all the employees
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    doGet(request, response);
	}

}
