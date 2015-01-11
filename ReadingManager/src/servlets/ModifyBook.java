package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import dao.BookDAO;

@WebServlet("/ModifyBook")
public class ModifyBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/ModifyBook.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BookDAO bookDAO = null;
		try 
		{	
			
			String bookId = request.getParameter("idModifyBook");
			BookBean book = new BookBean();
			book.setTitle(bookId);
			book.setAuthor(request.getParameter("tbAuthor")); 
			book.setlitteratureGenre(request.getParameter("tbGenre"));
			book.setLivre_desc(request.getParameter("tbDescription")); 
			bookDAO = new BookDAO();
			bookDAO.updateBook(book);
			response.sendRedirect("ModifiedBookValidation");
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			bookDAO.finalize();
		}

	}
}
