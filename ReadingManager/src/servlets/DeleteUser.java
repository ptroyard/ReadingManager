package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDAO;


@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserDAO userToDelete=null;
		try 
		{
			userToDelete = new UserDAO();
			UserBean user = new UserBean();
			user.setMail(request.getParameter("idDelete"));
			userToDelete.updateStatus(user);
			request.getRequestDispatcher("/WEB-INF/DeleteUser.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			userToDelete.finalize();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
