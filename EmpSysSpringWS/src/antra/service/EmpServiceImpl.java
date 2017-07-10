package antra.service;

import java.util.List;

import antra.dao.EmpDAO;
import antra.entity.Employee;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO empDAO;
	
	@Override
	@Transactional
	public void insertEmp(String firstName, String lastName, Integer age, Integer department) {
		empDAO.insert(firstName, lastName, age, department);

	}

	@Override
	@Transactional
	public List<Employee> loadEmpDetails() {
		return empDAO.queryEmployee();
	}

}
