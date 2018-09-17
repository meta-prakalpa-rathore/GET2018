package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dao.MysqlUserDao;
import facade.RegisterService;
import model.UserTOforRegister;


/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * service method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * service method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	    try
	    {
	        String firstName = request.getParameter("firstname");
	        String lastName = request.getParameter("lastname");
	        Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String contact = request.getParameter("contact");
	        String organization = request.getParameter("company");
	        
	        if(RegisterService.addUser(new UserTOforRegister(firstName, lastName, email, password, contact, organization, dob)))
	        {
	            Dao dao = new MysqlUserDao();
	            HttpSession session = request.getSession();
	            session.setAttribute("id", dao.getID(email));
	            request.getRequestDispatcher("Profile").forward(request, response);
	        }
	        else
	        {
	        	out.print("ERROR!! TRY AGAIN!!");
	        	response.sendRedirect("../view/register.html");
	        }
	        
	       
	    }
	    catch(ParseException e)
	    {
	        e.printStackTrace();
	    }
	    
	    
	}

}
