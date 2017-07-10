package servlet;

import employment.Employee;
import employment.Department;
import businessLogic.DepartmentService;
import businessLogic.EmployeeService;
import util.JdbcUtil;

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
import javax.servlet.http.HttpSession;


public class AddEmp extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8614043426629606222L;
	
	private List<Employee> empList;
	
	private List<Department> deptList;
	private Map<Integer, Department> deptMap;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
		
//		Connection conn = ju.getMySQLConnection();
		
				
		try {
			empList = EmployeeService.queryEmployee();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			deptList = DepartmentService.queryDepartment();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			deptMap = DepartmentService.quertDepartmentMap();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		int age = Integer.parseInt(req.getParameter("age"));
		int deptId = Integer.parseInt(req.getParameter("deptSelected"));
		
		System.out.println(firstName+lastName+age+deptId);
		
		Employee employee = new Employee(firstName, lastName, age, deptId);
		
		try {
			EmployeeService.insertEmployee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			empList = EmployeeService.queryEmployee();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("deptList", deptList);
		
//		req.setAttribute("employee", employee);
		req.setAttribute("empList", empList);
		req.getRequestDispatcher("addEmp.jsp").forward(req, resp);
	}

}
