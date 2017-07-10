package net.antra.deptemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.antra.deptemp.service.EmployeeService;

@Controller
public class EmpController {
	
	@Autowired
	private EmployeeService ems;
	
	@RequestMapping("/viewEmp")
	public String showDept(ModelMap model) {
		model.addAttribute("employeeList", ems.loadEmpBasicInfo());
		return "emp";
	}

	@RequestMapping("/manageEmp")
	public String manageDept(ModelMap model) {
		return "manageEmp";
	}
}
