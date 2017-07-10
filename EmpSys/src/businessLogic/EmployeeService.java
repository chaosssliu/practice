package businessLogic;

import util.JdbcUtil;

import employment.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class EmployeeService {
	
	//private static JdbcUtil ju;
	
	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void insertEmployee(Employee employee) throws SQLException {
		try {
			String sql = "INSERT INTO antra.employee(first_name, last_name, age, dept_id) VALUES(?, ?, ?, ?)";	
			Connection conn = JdbcUtil.getMySQLConnection();		
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, employee.getFirstName());
			pstm.setString(2, employee.getLastName());
			pstm.setInt(3, employee.getAge());
			pstm.setInt(4, employee.getDeptId());
			
			pstm.executeUpdate();
//			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Employee> queryEmployee() throws SQLException {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			String sql = "SELECT * FROM antra.employee";
			Connection conn = JdbcUtil.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String id = rs.getString("emp_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String age = rs.getString("age");
				String deptId = rs.getString("dept_id");
				
				Employee employee = new Employee();
				employee.setId(Integer.parseInt(id));
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setAge(Integer.parseInt(age));
				employee.setDeptId(Integer.parseInt(deptId));
				empList.add(employee);
			}
//			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return empList;
			
	}

}
