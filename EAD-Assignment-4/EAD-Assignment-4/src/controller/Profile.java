package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserTOforProfile;
import dao.Dao;
import dao.MysqlUserDao;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * service method to show profile
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
	    HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int id = (int)session.getAttribute("id");
		Dao dao = new MysqlUserDao();
		UserTOforProfile user = dao.fetchUserDetails(id);
		byte[] in = dao.getProfileImage(user.getEmail());
		String s = Base64.getEncoder().encodeToString(in);
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Profile</title>");
		out.print("<link href = '../stylesheets/forms.css' rel = 'stylesheet'>"
		        + "<link href = '../stylesheets/headers.css' rel = 'stylesheet'>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div><table class = 'header-font-1'>");
		out.print("<tr><td><img src='../images/html5logo.png' id='logo' height = 50px></td>");
		out.print("<td align = 'right'><a href='Profile'><span id = 'username'>" + user.getFirstName() + " " + user.getLastName() +"</span></a><a href = 'ShowFriends'>Show Friends</a><a href = 'Logout'>Logout</a></td>");
		out.print("</tr></table></div>");
		out.print("<div class='split left'>");
		out.print("<hr /><br /><br /><h1>Welcome</h1>");
		out.print("<table class='form-style-1'><tr>");
		out.print("<td><p><strong>First Name:</strong></p></td>");
		out.print("<td><p>" + user.getFirstName() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Last Name:</strong></p></td>");
		out.print("<td><p>" + user.getLastName() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Age:</strong></p></td>");
		out.print("<td><p>" + user.getAge() + "</p></td></tr>");
        out.print("<tr><td><p><strong>Email:</strong></p></td>");
		out.print("<td><p>" + user.getEmail() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Contact Number:</strong></p></td>");
		out.print("<td><p>" + user.getContact() + "</p></td></tr>");
		out.print("<tr><td><p><strong>Organization:</strong></p></td>");
		out.print("<td><p>" + user.getOrganization() + "</p></td></tr>");
		out.print("<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>"
		        + "<tr><td><a href='UpdateUser'>Edit</a></td></tr>");
		out.print("</table>");
		out.print("</div>");
		out.print("<div class='split right'>");
		out.print("<form action='UploadImage' method='post' enctype='multipart/form-data'>");
		out.print("<input type='hidden' name='email' value='" + user.getEmail() + "'>");
		out.print("<label for = 'image'>");
		out.print("<input type = 'file' name = 'image' id = 'image' style = 'display:none;'/>");
		out.print("<img id = 'profileImage' src = 'data:image/jpeg;base64, " + s + "' alt = 'images/defaultProfileImage.png' accept = 'image/*' />");
		out.print("</label>");
		out.print("<input type='submit' value='change'>");
		out.print("</form>");
		out.print("</div>");
		
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
