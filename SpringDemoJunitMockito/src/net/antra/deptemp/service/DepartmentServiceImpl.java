package net.antra.deptemp.service;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.deotemp.utility.Constants;
import net.antra.deptemp.dao.DepartmentDAO;
import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.DeptEmpCode;

@Service//use service to indicate it is a service layer
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired // Dependency Injection, inject the DAO
	DepartmentDAO deptDAO;
	@Override
	@Transactional // Make the method executed in a transaction // em.getTrasction.begin()
	public void saveDept(Department dept) {
		if(dept.getStatus() == null){
			DeptEmpCode status = new DeptEmpCode();
			status.setcId(Constants.DEFAUL_DEPT_STATUS_ID);
			dept.setStatus(status);
		}
		deptDAO.save(dept);
		//throw new RuntimeException();
	}
	//em.getTransaction.commit//  

	@Override
	@Transactional
	public List<Department> loadDeptDetails() {
		List<Department> dList = deptDAO.findAllDepartments();
		return dList;
	}

	@Override
	@Transactional
	public List<Department> loadDeptBasicInfo() {
		return deptDAO.findBasicDeptInfo();
	}

	public DepartmentDAO getDeptDAO() {
		return deptDAO;
	}

	public void setDeptDAO(DepartmentDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

}
