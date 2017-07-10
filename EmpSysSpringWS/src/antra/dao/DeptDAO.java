package antra.dao;

import antra.entity.Department;

import java.util.*;

public interface DeptDAO {
	
	Department queryDeptById(int id);
	
	void insert(Department department);
	
	List<Department> queryDepartment();

}
