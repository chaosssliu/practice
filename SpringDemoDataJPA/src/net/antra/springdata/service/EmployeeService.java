package net.antra.springdata.service;

import java.util.List;

import net.antra.springdata.entity.Employee;


public interface EmployeeService {

	public List<Employee> loadEmpBasicInfo();

	public Employee getEmpById(int i);

	public Employee findEmpByFirstNameAndLastName(String firstName, String lastName);

}
