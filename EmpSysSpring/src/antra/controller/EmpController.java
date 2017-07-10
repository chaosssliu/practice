package antra.controller;

import antra.entity.Employee;
import antra.entity.Department;
import antra.service.EmpService;
import antra.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	
	@Autowired
	DeptService deptService;
	
	@RequestMapping("/loadEmp")
	public String showLoadEmp(ModelMap model) {
		model.addAttribute("deptList", deptService.loadDeptDetails());
		model.addAttribute("empList", empService.loadEmpDetails());
		return "addEmp";
	}
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String showInsertEmp(ModelMap model, @RequestParam String firstName, 
			@RequestParam String lastName, @RequestParam Integer age, @RequestParam Integer department) {
		empService.insertEmp(firstName, lastName, age, department);
		model.addAttribute("empList", empService.loadEmpDetails());
		model.addAttribute("deptList", deptService.loadDeptDetails());
		return "addEmp";
	}
	
	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	public String deleteEmp(ModelMap model, @RequestParam Integer id) {
		empService.deleteEmpById(id);
		model.addAttribute("empList", empService.loadEmpDetails());
		model.addAttribute("deptList", deptService.loadDeptDetails());
		return "addEmp";
	}
}
