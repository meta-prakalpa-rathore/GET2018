package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dao.MysqlUserDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * service method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Dao dao = new MysqlUserDao();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(dao.validateLogin(email, password))
        {
            HttpSession session = request.getSession();
            session.setAttribute("id", dao.getID(email));
            request.getRequestDispatcher("Profile").forward(request, response);
        }
        else
        {
            out.print("INVALID LOGIN");
            request.getRequestDispatcher("../view/login.html").include(request, response);
        }
	}

}
