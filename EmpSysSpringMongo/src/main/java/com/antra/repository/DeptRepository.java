package com.antra.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.antra.entity.Department;

@Repository
public class DeptRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<Department> loadDeptDetails() {
		List<Department> listDept = mongoTemplate.findAll(Department.class);
		return listDept;
	}
	
	public void addDept(Department department) {
		mongoTemplate.insert(department);
	}
}
