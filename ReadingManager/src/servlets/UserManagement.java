package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDAO;

@WebServlet("/UserManagement")
public class UserManagement extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		UserDAO userDAO=null;
		try 
		{
			userDAO = new UserDAO();
			List<UserBean> userList  = userDAO.getAllUser();
		
			request.setAttribute("userList", userList);
			for (UserBean userBean : userList) {
				userBean.getMail();
			}
			request.getRequestDispatcher("/WEB-INF/UserManagement.jsp").forward(request, response);
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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.sendRedirect("SearchResults");
		
	}

}
