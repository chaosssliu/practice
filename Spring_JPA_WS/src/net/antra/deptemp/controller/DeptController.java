 package net.antra.deptemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.service.DepartmentService;

@Controller
public class DeptController {
	@Autowired
	DepartmentService deptService;
	
	@RequestMapping("/getDeptDetail")
	@ResponseBody
	public Department getDeptDetail(int id) {
		return deptService.loadDeptDetailById(id);
	}
	@RequestMapping("/viewDept")
	public String showDept(ModelMap model) {
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "dept";
	}

	@RequestMapping("/manageDept")
	public String showManageDept(ModelMap model) {
		return "manageDept";
	}
	
	@RequestMapping(value = "/addDept", method = RequestMethod.POST)
	public String showAddDept(Department dept, ModelMap model) {
		try{
			deptService.saveDept(dept);
			model.addAttribute("success", "Successfully add a department.");
		}catch(Exception e){
			model.addAttribute("fail", "Sorry, it failed to add a department.");
		}
		return "manageDept";
	}
}
