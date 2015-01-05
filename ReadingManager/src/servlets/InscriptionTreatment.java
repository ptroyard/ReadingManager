package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InscriptionTreatment")
public class InscriptionTreatment extends HttpServlet 
{

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		
		String name=request.getParameter("tbName");
		
		if(name.matches("password"))
		{
			this.getServletContext().getRequestDispatcher( "/InscriptionTreatment.jsp").forward( request, response );
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("Login failed");
		}

	}
	
}
