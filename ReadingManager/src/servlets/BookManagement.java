package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import dao.BookDAO;

@WebServlet("/BookManagement")
public class BookManagement extends HttpServlet 
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		BookDAO bookDAO=null;
		try 
		{
			bookDAO = new BookDAO();
			List<BookBean> bookList  = bookDAO.getAllBooks();
		
			request.setAttribute("bookList", bookList);
			for (BookBean bookBean : bookList) {
				bookBean.getTitle();
			}
			request.getRequestDispatcher("/WEB-INF/BookManagement.jsp").forward(request, response);
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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.sendRedirect("SearchBookResults");
		
	}
}
