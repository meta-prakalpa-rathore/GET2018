package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import dao.MysqlUserDao;

/**
 * Servlet implementation class UploadImage
 */
@MultipartConfig(maxFileSize = 16177215)
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * service method to update profile picture
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Dao dao = new MysqlUserDao();
	    PrintWriter out = response.getWriter();
	    InputStream inputStream = null;
	    String email = request.getParameter("email");
	    Part filePart = request.getPart("image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            if(dao.setProfileImage(inputStream, email))
            {
                out.print("profile image set");
                request.getRequestDispatcher("Profile").forward(request, response);
            }
            else
            {
                out.print("Error setting image!! Please try again!!");
            }
        }
	}

}
