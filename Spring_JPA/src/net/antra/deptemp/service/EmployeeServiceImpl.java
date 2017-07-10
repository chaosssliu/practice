package net.antra.deptemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.deptemp.dao.EmployeeDAO;
import net.antra.deptemp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;

	@Override
	public List<Employee> loadEmpBasicInfo() {
		return empDAO.getEmployeeList();
	}

}
