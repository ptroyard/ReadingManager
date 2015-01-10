package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterValidation")
public class RegisterValidation extends HttpServlet 
{
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getSession().getAttribute("registrationError")==null){
			request.getRequestDispatcher("/WEB-INF/RegisterValidation.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/WEB-INF/RegistrationFailed.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
