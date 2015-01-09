package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.AppConfigDAO;
import manager.MailSendingManager;


@WebServlet("/ContactUS")
public class ContactUS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MailSendingManager mailMan;
    public ContactUS() {
        super();
        mailMan = new MailSendingManager();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ContactUS.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		AppConfigDAO appConfig = new AppConfigDAO();
		String to = appConfig.getAdminMail();
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");
		try(PrintWriter out = response.getWriter()){
			mailMan.sendMail(to, subject, body);
			request.getRequestDispatcher("/WEB-INF/MailSent.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
