package servlet;

import employment.Department;
import employment.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.DepartmentService;
import businessLogic.EmployeeService;

public class AddDept extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8981756357724957876L;
	
	private Map<Integer, Department> deptMap;
	private List<Department> deptList;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
		
//		Connection conn = ju.getMySQLConnection();
		
		
		deptList = DepartmentService.queryDepartment();
		
		
		String deptName = req.getParameter("deptName");
		String deptEmail = req.getParameter("deptEmail");
		
//		Department department = new Department(deptName, deptEmail);
		
		DepartmentService.insertDepartment(deptName, deptEmail);
		
		deptList = DepartmentService.queryDepartment();
		
//		req.setAttribute("department", department);
		req.setAttribute("deptList", deptList);
		req.getRequestDispatcher("addDept.jsp").forward(req, resp);
	}
	
}
