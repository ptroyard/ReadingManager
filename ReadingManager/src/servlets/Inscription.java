package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDAO;


@WebServlet("/Inscription")
public class Inscription extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		try 
		{
			UserBean createdUser = new UserBean();
			createdUser.setMail(request.getParameter("tbMail")); 
			createdUser.setAdress(request.getParameter("tbAddress"));
			createdUser.setLastName(request.getParameter("tbName"));
			createdUser.setFirstName(request.getParameter("tbFirstName"));
			createdUser.setTel(request.getParameter("tbTelephone"));
			
			if("Reader".equals(request.getParameter("rbAdmin")))
			{
				createdUser.setAdmin(false);
			}
			else
			{
				createdUser.setAdmin(true);
			}
			
			UserDAO userDAO= new UserDAO();
			userDAO.insertUser(createdUser);
			
			request.getSession().setAttribute("createdUser", createdUser);
			response.sendRedirect("RegisterValidation");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
