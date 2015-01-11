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



@WebServlet("/SearchBookResults")
public class SearchBookResults extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		BookDAO bookDAO=null;
		try 
		{
			bookDAO = new BookDAO();
			BookBean bookToFind = new BookBean();
			bookToFind.setTitle(request.getParameter("tbSearchByTitle"));
			bookToFind.setAuthor(request.getParameter("tbSearchByAuthor"));
			bookToFind.setlitteratureGenre(request.getParameter("tbSearchByGenre"));
			bookToFind.setLivre_desc(request.getParameter("tbSearchByDescription"));
			
			List<BookBean> bookList  = bookDAO.getBooks(bookToFind);
		
			request.setAttribute("bookList", bookList);
			for (BookBean bookBean : bookList) {
				bookBean.getTitle();
			}
			request.getRequestDispatcher("/WEB-INF/SearchBookResults.jsp").forward(request, response);
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
