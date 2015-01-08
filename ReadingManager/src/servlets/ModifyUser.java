package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDAO;

@WebServlet("/ModifyUser")
public class ModifyUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/ModifyUser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{	
			
			String userId = request.getParameter("idModifyUser");
			UserBean user = new UserBean();
			user.setMail(userId);
			user.setLastName(request.getParameter("tbName")); 
			user.setFirstName(request.getParameter("tbFirstName"));
			user.setAdress(request.getParameter("tbAddress")); 
			user.setTel(request.getParameter("tbTelephone"));
			UserDAO userDAO = new UserDAO();
			userDAO.updateUser(user);
			response.sendRedirect("ModifiedUserValidation");
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
