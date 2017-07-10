package antra.service;

import antra.entity.Department;

import java.util.*;

public interface DeptService {
	
	public void insertDept(Department department);
	
	public List<Department> loadDeptDetails();

}
