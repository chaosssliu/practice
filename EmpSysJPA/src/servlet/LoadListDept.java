package servlet;

import employment.Employee;
import employment.Department;
import businessLogic.DepartmentService;
import businessLogic.EmployeeService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoadListDept extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -880713713078242132L;
	private List<Department> deptList;
//	private List<Employee> empList;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
/*		
		try {
			empList = EmployeeService.queryEmployee();
		} catch (SQLException e) {
			e.printStackTrace();
		}
*/		
		
		deptList = DepartmentService.queryDepartment();
		
		
//		req.setAttribute("empList", empList);
		req.setAttribute("deptList", deptList);
		req.getRequestDispatcher("addDept.jsp").forward(req, resp);
		
	}
	
	

}
