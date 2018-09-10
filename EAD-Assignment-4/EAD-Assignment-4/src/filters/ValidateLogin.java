package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dao.MysqlUserDao;

/**
 * Servlet Filter implementation class ValidateLogin
 */
public class ValidateLogin implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpSession session = httpRequest.getSession(false);
	    
	    if(session != null)
	        chain.doFilter(request, response);
	    else
	    {
	        out.print("You need to login first");
            request.getRequestDispatcher("../view/login.html").include(request, response);
	    }
		
	}

	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}

}
