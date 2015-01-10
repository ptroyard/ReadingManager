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

/**
 * Servlet implementation class ActivateAccount
 */
@WebServlet("/ActivateAccount")
public class ActivateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ActivateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try{
		String mail = request.getParameter("user");
		UserDAO userDAO= new UserDAO();
		UserBean userBean = userDAO.getUser(mail);
		boolean status = userBean.isStatus();
		if(!status){
			userBean.setStatus(true);
		}
		HttpSession session = request.getSession();
		session.setAttribute("status", status);
		request.getRequestDispatcher("/WEB-INF/ActivateAccount.jsp?").forward(request, response);
		}catch(Exception e){
			out.println("<h1 align='center'>"+e.getMessage()+"</h1>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
