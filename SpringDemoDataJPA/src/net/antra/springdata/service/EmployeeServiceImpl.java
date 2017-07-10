package net.antra.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.springdata.dao.EmployeeDAO;
import net.antra.springdata.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;

	@Override
	public List<Employee> loadEmpBasicInfo() {
		return empDAO.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
		return empDAO.findOne(id);
	}

	@Override
	public Employee findEmpByFirstNameAndLastName(String firstName, String lastName) {
		return empDAO.findEmployeeByFirstNameAndLastName(firstName,lastName);
	}

}
