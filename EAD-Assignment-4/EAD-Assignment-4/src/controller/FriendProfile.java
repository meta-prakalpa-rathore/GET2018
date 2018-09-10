package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.api.server.SDDocumentFilter;

import dao.Dao;
import dao.MysqlUserDao;
import model.UserTOforProfile;

/**
 * Servlet implementation class FriendProfile
 */
public class FriendProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * service method 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
	    HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int id = (int)session.getAttribute("id");
		Dao dao = new MysqlUserDao();
		UserTOforProfile user = dao.fetchUserDetails(id);
		UserTOforProfile friend = dao.fetchUserDetails(dao.getID(request.getParameter("email")));
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
				
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Friend Profile</title>");
		out.print("<link href = '../stylesheets/forms.css' rel = 'stylesheet'>"
		        + "<link href = '../stylesheets/headers.css' rel = 'stylesheet'>");
		out.print("</head>");
		out.print("<body><table class = 'header-font-1'>");
		out.print("<tr><td><img src='../images/html5logo.png' id='logo' height = 50px></td>");
		out.print("<td align = 'right'><a href='Profile'><span id = 'username'>" + user.getFirstName() + " " + user.getLastName() +"</span></a><a href = 'ShowFriends'>Show Friends</a><a href = 'Logout'>Logout</a></td>");
		out.print("</tr></table>");
		out.print("<hr /><br /><br /><h1>Profile</h1>");
		out.print("<table class='form-style-1'><tr>");
		out.print("<td><p><strong>First Name:</strong></p></td>");
		out.print("<td><p>" + friend.getFirstName() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Last Name:</strong></p></td>");
		out.print("<td><p>" + friend.getLastName() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Date of Birth:</strong></p></td>");
		out.print("<td><p>" +  sdFormat.format(friend.getDob()) + "</p></td></tr>");
		out.print("<tr><td><p><strong>Age:</strong></p></td>");
		out.print("<td><p>" + friend.getAge() + "</p></td></tr>");
        out.print("<tr><td><p><strong>Email:</strong></p></td>");
		out.print("<td><p>" + friend.getEmail() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Contact Number:</strong></p></td>");
		out.print("<td><p>" + friend.getContact() + "</p></td></tr>");
		out.print("</table>");
		out.print("<footer id = 'fixfooter'>&copy;Copyright 2017-18 | All Rights Reserved | Metacube Training</footer>");
		out.print("</body></html>");
	}

	/**
	 * service method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
