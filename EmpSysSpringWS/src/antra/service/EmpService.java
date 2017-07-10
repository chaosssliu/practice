package antra.service;

import antra.entity.Employee;

import java.util.List;

public interface EmpService {

	public void insertEmp(String firstName, String lastName, Integer age, Integer department);
	
	public List<Employee> loadEmpDetails();
}
