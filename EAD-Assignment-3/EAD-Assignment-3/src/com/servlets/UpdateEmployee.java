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
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * service method to allow user to change employee details
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String oldFname = request.getParameter("fname");
	    String oldLname = request.getParameter("lname");
	    String oldEmail = request.getParameter("email");
	    int oldAge = Integer.parseInt(request.getParameter("age"));
	    
	    out.print("<html><head>");
        out.print("<link href='styling.css' rel='stylesheet'></link>");
        out.print("<script src = 'validation.js'></script>");
        out.print("</head>");
        out.print("<body>");
        out.print("<br/> <br/>");
	    out.print("<h1>Update details</h1>");
	    out.print("<br/> <br/>");
	    out.print("<form id='employeeForm' action='UpdateEmployee' method=\"post\"><table class='form-style-1'>");
	    out.print("<tr><td>First Name</td><td><input type='text' name='fname' value='" + oldFname + "' id = 'fname' onfocusout = 'firstNameValidate()'></td>"
	            + "</tr><tr><td></td><td><span id = 'fnameErr'></span></td></tr>");
	    out.print("<tr><td>Last Name</td><td><input type='text' name='lname' value='" + oldLname + "' id = 'lname' onfocusout = 'lastNameValidate()'></td>"
	            + "</tr><tr><td></td><td><span id = 'lnameErr'></span></td></tr>");
	    out.print("<tr><td>Email</td><td><input type='text' name='email' value='" + oldEmail + "' id = 'email' onfocusout = 'emailValidate()'></td>"
	            + "</tr><tr><td></td><td><span id = 'emailErr'></span></td></tr>");
	    out.print("<tr><td>Age</td><td><input type='text' name='age' value='" + oldAge + "' id = 'age' onfocusout = 'ageValidate()'></td>"
	            + "</tr><tr><td></td><td><span id = 'ageErr'></span></td></tr>");
	    out.print("<input type='hidden' name='oldEmail' value='"+oldEmail+"'>");
	    out.print("<tr><td></td><td><input type='button' value='Update' onclick = 'submitForm()'></td></tr>");
	    out.print("</table></form>");
	    out.print("</html>");
	}

	
	/**
     * service method to allow user to edit employee details
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

}
