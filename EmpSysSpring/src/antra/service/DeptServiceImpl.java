package antra.service;

import antra.entity.Department;
import antra.dao.DeptDAO;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptDAO deptDAO;

	@Override
	@Transactional
	public void insertDept(Department department) {
		deptDAO.insert(department);

	}

	@Override
	@Transactional
	public List<Department> loadDeptDetails() {
		return deptDAO.queryDepartment();
	}

}
