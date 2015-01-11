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
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BookDAO bookToDelete=null;
		try 
		{
			bookToDelete = new BookDAO();
			BookBean book = new BookBean();
			book.setTitle(request.getParameter("idDelete"));
			bookToDelete.deleteBook(book);
			request.getRequestDispatcher("/WEB-INF/DeleteBook.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			bookToDelete.finalize();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
