package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8306594688810390239L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
		
		req.setAttribute("message2", "You are successfully logged out!");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
//		out.print("<p align='center'>You are successfully logged out!</p>");
		
		HttpSession session = req.getSession(false);
		session.invalidate();
		
//		out.close();
	}

}
