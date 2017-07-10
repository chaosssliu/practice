package businessLogic;

import util.JdbcUtil;
import employment.Department;
import employment.Employee;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class DepartmentService {
	
	//private static JdbcUtil ju;
	
	public DepartmentService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void insertDepartment(Department department) throws SQLException {
		try {
			String sql = "INSERT INTO antra.department(dept_name, dept_email) VALUES(?, ?)";	
			Connection conn = JdbcUtil.getMySQLConnection();		
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, department.getName());
			pstm.setString(2, department.getEmail());
			
			pstm.executeUpdate();
		} catch(Exception e) {
			
		}
	}
	
	public static Map<Integer, Department> quertDepartmentMap() throws SQLException {
		Map<Integer, Department> deptMap = new HashMap<>();
		try {
			String sql = "SELECT * FROM antra.department";
			Connection conn = JdbcUtil.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				int deptId = Integer.parseInt(rs.getString("dept_id"));
				String deptName = rs.getString("dept_name");
				String deptEmail = rs.getString("dept_email");
				
				Department department = new Department();
				department.setId(deptId);
				department.setName(deptName);
				department.setEmail(deptEmail);
				
				if (!deptMap.containsKey(deptId)) {
					deptMap.put(deptId, department);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return deptMap;
		
	}
	

	public static List<Department> queryDepartment() throws SQLException {
		List<Department> deptList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM antra.department";
			Connection conn = JdbcUtil.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("dept_id"));
				String deptName = rs.getString("dept_name");
				String deptEmail = rs.getString("dept_email");
				
				Department department = new Department();
				department.setId(id);
				department.setName(deptName);
				department.setEmail(deptEmail);
				deptList.add(department);
			}
		} catch(Exception e) {
			
		}
		
		return deptList;			
	}
	

}
