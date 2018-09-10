package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserTOforProfile;
import dao.Dao;
import dao.MysqlUserDao;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * service method to edit user details
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    

	        response.setContentType("text/html");
	        HttpSession session = request.getSession();
	        PrintWriter out = response.getWriter();
	        int id = (int)session.getAttribute("id");
	        Dao dao = new MysqlUserDao();
	        UserTOforProfile user = dao.fetchUserDetails(id);
	        
	        out.print("<html><head>");
	        out.print("<title>Update Profile</title>");
	        out.print("<link href='../stylesheets/forms.css' rel='stylesheet'></link>"
	                + "<link href = '../stylesheets/headers.css' rel = 'stylesheet'>");
	        out.print("<script src = '../scripts/validation.js'></script>");
	        out.print("</head>");
	        out.print("<body>");
	        out.print("<div><table class = 'header-font-1'>");
	        out.print("<tr><td><img src='../images/html5logo.png' id='logo' height = 50px></td>");
	        out.print("<td align = 'right'><a href='Profile'><span id = 'username'>" + user.getFirstName() + " " + user.getLastName() +"</span></a><a href = 'ShowFriends'>Show Friends</a><a href = 'Logout'>Logout</a></td>");
	        out.print("</tr></table></div>");
	        out.print("<br/> <br/>");
	        out.print("<h1>Update details</h1>");
	        out.print("<br/> <br/>");
	        out.print("<form id='userForm' action='UpdateUser' method=\"post\"><table class='form-style-1'>");
	        out.print("<tr><td>First Name</td><td><input type='text' name='fname' value='" + user.getFirstName() + "' id = 'fname' onfocusout = 'firstNameValidate()'></td>"
	                + "</tr><tr><td></td><td><span id = 'fnameErr'></span></td></tr>");
	        out.print("<tr><td>Last Name</td><td><input type='text' name='lname' value='" + user.getLastName() + "' id = 'lname' onfocusout = 'lastNameValidate()'></td>"
	                + "</tr><tr><td></td><td><span id = 'lnameErr'></span></td></tr>");
	        out.print("<tr><td>Email</td><td><input type='text' name='email' value='" + user.getEmail() + "' id = 'email' onfocusout = 'emailValidate()'></td>"
	                + "</tr><tr><td></td><td><span id = 'emailErr'></span></td></tr>");
	        out.print("<tr><td>Contact</td><td><input type='text' name='contact' value='" + user.getContact() + "' id = 'contact' onfocusout = 'contactValidate()'></td>"
	                + "</tr><tr><td></td><td><span id = 'contactErr'></span></td></tr>");
	        out.print("<tr><td>Date of Birth</td><td><input type='date' name='dob' value='" + user.getDob() + "' id = 'dob'></td>"
                    + "</tr><tr><td></td><td><span id = 'dobErr'></span></td></tr>");
	        out.print("<tr><td>Organization</td>");
	        out.print("<td><select name='company' id='company' class='field-select'>");
	        out.print("<option value='" + user.getOrganization() + "'>" + user.getOrganization() + "</option>");
	        out.print("<option value='metacube'>Metacube Software Pvt. Ltd.</option>");
	        out.print("<option value='infosys'>Infosys Limited</option>");
	        out.print("<option value='google'>Google LLC</option>");
	        out.print("<option value='microsoft'>Microsoft Corporation</option>");
	        out.print("<option value='tcs'>Tata Consultancy Services Limited</option>");
	        out.print("</select></td></tr>");
	        
	        out.print("<tr><td></td><td><input type='button' value='Update' onclick = 'submitUser()'></td></tr>");
	        out.print("</table></form>");
	        out.print("<footer id = 'fixfooter'>&copy;Copyright 2017-18 | All Rights Reserved | Metacube Training</footer>");
	        out.print("</body></html>");
	    
	}

	/**
	 * service method to update user details 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try
	    {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession();
	        int id = (int)session.getAttribute("id");
	        Dao dao = new MysqlUserDao();
	        UserTOforProfile updateUser = new UserTOforProfile(request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email"), request.getParameter("contact") , request.getParameter("company"), 0, new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")));
	        if(dao.updateUser(updateUser, id))
	            out.print("<script>alert(\"successfully updated!\")</script>");
	        else
	            out.print("<script>alert(\"ERROR!\")</script>");
	        
	        request.getRequestDispatcher("Profile").forward(request, response);
	    }
	    catch(ParseException e)
	    {
	        e.printStackTrace();
	    }
	    
	}

}
