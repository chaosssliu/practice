package net.antra.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.antra.springdata.entity.Department;
import net.antra.springdata.entity.TestEmp;
import net.antra.springdata.service.DepartmentService;

@Controller
@EnableAutoConfiguration
public class DeptController {
	
	@Autowired
	DepartmentService dService;
	
	@RequestMapping(value = "/emp")
	@ResponseBody
	public String getEmp(){
		System.out.println(123);
		//return new TestEmp("asdf");
		return "abc";
	}

	@RequestMapping(value = "/dept")
	@ResponseBody
	public TestEmp getDept(){
		Department dept = new Department();
		dept.setName("Test_Dept");
		dService.loadDeptDetails();
		return new TestEmp("asdf");
	}
}
