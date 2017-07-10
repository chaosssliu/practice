package net.antra.springdata.service;

import java.util.List;

import net.antra.springdata.entity.Department;


public interface DepartmentService{
	public void saveDept(Department dept);

	public List<Department> loadDeptDetails();

	public List<Department> loadDeptBasicInfo();

}
