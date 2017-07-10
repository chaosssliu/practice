package com.antra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.antra.entity.Department;
import com.antra.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService deptService;
	
	@RequestMapping(value="/loadDept", method=RequestMethod.GET)
	public String loadDeptDetails(ModelMap model) {
		model.addAttribute("deptList", deptService.loadDeptDetails());
		return "addDept";
	}
	
	@RequestMapping(value="/addDept", method=RequestMethod.POST)
	public String addDept(Department dept, ModelMap model) {
		deptService.addDept(dept);
		model.addAttribute("deptList", deptService.loadDeptDetails());
		return "addDept";
	}
}
