package servlets;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.io.IOException;


@WebServlet("/Logout")
public class Logout extends HttpServlet 
{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//Kill session
		 HttpSession session = request.getSession(false);
		 if (session != null) 
		 {
		     session.invalidate();
		 }
		 
		response.sendRedirect("Connexion.jsp"); 	

	}

}




