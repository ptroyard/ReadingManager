package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import dao.UserDAO;

@WebServlet("/InscriptionTreatment")
public class InscriptionTreatment extends HttpServlet 
{

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
			response.sendRedirect("RegisterValidation.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
}
