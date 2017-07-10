package com.antra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antra.entity.Department;
import com.antra.repository.DeptRepository;

@Service
public class DeptService {

	@Autowired
	DeptRepository deptRepository;
	
	@Transactional
	public List<Department> loadDeptDetails() {
		return deptRepository.loadDeptDetails();
	}
	
	@Transactional
	public void addDept(Department department) {
		deptRepository.addDept(department);
	}
}
