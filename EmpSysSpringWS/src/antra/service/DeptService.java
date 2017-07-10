package antra.service;

import antra.entity.Department;

import java.util.*;

public interface DeptService {
	
	public Department loadDeptDetailsById(int id);
	
	public void insertDept(Department department);
	
	public List<Department> loadDeptDetails();

}
