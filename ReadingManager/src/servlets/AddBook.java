package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import dao.BookDAO;


/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/AddBook.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BookDAO bookDAO= null;
		try 
		{
			bookDAO = new BookDAO();
			BookBean createdBook = new BookBean();
			createdBook.setTitle(request.getParameter("tbTitle")); 
			createdBook.setAuthor(request.getParameter("tbAuthor"));
			createdBook.setlitteratureGenre(request.getParameter("tbGenre"));
			createdBook.setLivre_desc(request.getParameter("tbDescription"));
			
			bookDAO.insertBook(createdBook);
			
			request.getSession().setAttribute("createdBook", createdBook);
			response.sendRedirect("RegisterBookValidation");
		} 
		catch (Exception e) 
		{
			request.getSession().setAttribute("registrationError", e.getMessage());
			response.sendRedirect("RegisterBookValidation");
		}
		finally{
			bookDAO.finalize();
		}
	}

}
