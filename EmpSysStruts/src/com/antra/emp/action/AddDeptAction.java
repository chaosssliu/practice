package com.antra.emp.action;

import com.antra.emp.entity.Department;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddDeptAction extends ActionSupport implements ModelDriven {

	private Department department = new Department();

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void validate() {
		
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
