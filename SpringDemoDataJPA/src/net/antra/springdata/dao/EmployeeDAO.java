package net.antra.springdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.antra.springdata.entity.Employee;


public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	Employee findEmployeeByFirstNameAndLastName(String firstName, String lastName);
	
}
