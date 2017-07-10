package antra.dao;

import antra.entity.Department;

import java.util.*;

public interface DeptDAO {
	
	void insert(Department department);
	
	List<Department> queryDepartment();
	

}
