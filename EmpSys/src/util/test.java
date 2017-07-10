package util;

import java.util.*;
import employment.Department;
import java.sql.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Department> deptList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM antra.department";
			Connection conn = JdbcUtil.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String deptName = rs.getString("dept_name");
				String deptEmail = rs.getString("dept_email");
				Department department = new Department();
				department.setName(deptName);
				department.setEmail(deptEmail);
				deptList.add(department);
				System.out.println(deptName+deptEmail);
			}
		} catch(Exception e) {
			
		}
	}

}
