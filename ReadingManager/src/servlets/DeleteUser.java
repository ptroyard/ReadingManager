package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;


@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			UserDAO userToDelete = new UserDAO();
			String user = request.getParameter("idDelete");
			userToDelete.deleteUser(user);
			request.getRequestDispatcher("/WEB-INF/DeleteUser.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
