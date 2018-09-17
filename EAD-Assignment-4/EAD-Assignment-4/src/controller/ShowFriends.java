package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

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
 * Servlet implementation class ShowFriends
 */
@WebServlet("/ShowFriends")
public class ShowFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * service method to show friends
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int id = (int)session.getAttribute("id");
        Dao dao = new MysqlUserDao();
        UserTOforProfile user = dao.fetchUserDetails(id);
        List<UserTOforProfile> listOfFriends = dao.getFriends(id, user.getOrganization());
    
        out.print("<html><head>");
        out.print("<title>Friends</title>");
        out.print("<link href='../stylesheets/forms.css' rel='stylesheet'></link>"
                + "<link href = '../stylesheets/headers.css' rel = 'stylesheet'></head>");
        out.print("<body>");
        out.print("<div><table class = 'header-font-1'>");
        out.print("<tr><td><img src='../images/html5logo.png' id='logo' height = 50px></td>");
        out.print("<td align = 'right'><a href='Profile'><span id = 'username'>" + user.getFirstName() + " " + user.getLastName() +"</span></a><a href = 'ShowFriends'>Show Friends</a><a href = 'Logout'>Logout</a></td>");
        out.print("</tr></table></div>");
        out.print("<br/> <br/>");
        out.print("<h1>Friends details</h1>");
        out.print("<br/> <br/>");
        out.print("<table class='form-style-1'>");
        out.print("<tr><th>First Name</th><th></th><th>Last Name</th></tr>");
        out.print("<tr><td><br/></td></tr>");
        
        for(UserTOforProfile friend: listOfFriends)
        {
            out.print("<tr><td>" + friend.getFirstName() + "</td><td></td><td>" + friend.getLastName() + "</td>");
            out.print("<td></td><td><a href='FriendProfile?email=" + friend.getEmail() + "'>See Profile</a></td>");
            out.print("<tr><td><br/></td></tr>");
        }
        
        out.print("</table>");
        out.print("<footer id = 'fixfooter'>&copy;Copyright 2017-18 | All Rights Reserved | Metacube Training</footer>");
        out.print("</body></html>");
        out.close();
	}

}
