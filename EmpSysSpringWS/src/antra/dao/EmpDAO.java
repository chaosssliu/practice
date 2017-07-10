package antra.dao;

import antra.entity.Employee;

import java.util.*;

public interface EmpDAO {

	void insert(String firstName, String lastName, Integer age, Integer department);
	
	List<Employee> queryEmployee();
}
