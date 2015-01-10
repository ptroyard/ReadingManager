package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MailSendingManager;
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
		UserDAO userDAO= null;
		MailSendingManager mailMan = new MailSendingManager();
		try 
		{
			userDAO = new UserDAO();
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
			userDAO.insertUser(createdUser);
			String subject = "Your Reading Manager account is ready";
			String body = "<h3>Your Reading Manager account is ready!</h3>"
					+ "<p>Dear "+createdUser.getFirstName()+" "+createdUser.getLastName()+"</p>"
					+"<p>Here is your password: "+createdUser.getPassword()+"</p>"
					+"<p>Complete your registration by activating your account below</p>"
					+"<a href='http://localhost:8080/ReadingManager/ActivateAccount?user="+createdUser.getMail()+"'>Activate Account</a>"
					+"<p>Happy Rating!<br/>Reading Manager Team.";
			mailMan.sendMail(createdUser.getMail(), subject, body);
			request.getSession().setAttribute("createdUser", createdUser);
			response.sendRedirect("RegisterValidation");
		} 
		catch (Exception e) 
		{
			request.getSession().setAttribute("registrationError", e.getMessage());
			response.sendRedirect("RegisterValidation");
		}
		finally{
			userDAO.finalize();
		}

	}

}
