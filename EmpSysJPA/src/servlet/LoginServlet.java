package servlet;

import employment.Department;
import employment.Employee;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.DepartmentService;



public class LoginServlet extends HttpServlet {
	
//	private List<Department> deptList;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2345862321847543427L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		if ((username.equals("admin") && password.equals("123456"))
			||(username.equals("owen") && password.equals("123456"))) {
//			out.print("Welcome " + username);
			
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
			resp.sendRedirect("login.jsp");
		} else {
//			out.print("<font color=red>Incorrect User name or Password.</font>");
			req.setAttribute("message1", "Incorrect User Name or Password.");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		
//		out.close();
		
		
		
	}
	
	

}
