package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDAO;

@WebServlet("/SearchResults")
public class SearchResults extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		UserDAO userDAO=null;
		try 
		{
			userDAO = new UserDAO();
			UserBean userToFind = new UserBean();
			userToFind.setMail(request.getParameter("tbSearchByMail"));
			userToFind.setFirstName(request.getParameter("tbSearchByFirstName"));
			userToFind.setLastName(request.getParameter("tbSearchByLastName"));
			userToFind.setAdress(request.getParameter("tbSearchByAddress"));
			userToFind.setTel(request.getParameter("tbSearchByPhone"));
			
			List<UserBean> userList  = userDAO.getUsers(userToFind);
		
			request.setAttribute("userList", userList);
			for (UserBean userBean : userList) {
				userBean.getMail();
			}
			request.getRequestDispatcher("/WEB-INF/SearchResults.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			
			userDAO.finalize();
		}
		
	}

}
