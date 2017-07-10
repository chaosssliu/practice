package antra.controller;

import antra.entity.Department;
import antra.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	@RequestMapping("/loadDept")
	public String showLoadDept(ModelMap model) {
		model.addAttribute("deptList", deptService.loadDeptDetails());
		return "addDept";
	}
	
	@RequestMapping(value = "/addDept", method = RequestMethod.POST)
	public String showInsertDept(Department dept, ModelMap model) {
		deptService.insertDept(dept);
		model.addAttribute("deptList", deptService.loadDeptDetails());
		return "addDept";
	}

}
