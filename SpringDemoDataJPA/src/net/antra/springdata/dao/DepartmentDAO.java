package net.antra.springdata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.antra.springdata.entity.Department;


public interface DepartmentDAO  extends JpaRepository<Department, Integer>{

	@Query("select DISTINCT OBJECT(d) from Department d LEFT OUTER JOIN FETCH d.employeeList")
	List<Department> findAllDepartments();
	@Query("select DISTINCT OBJECT(d) from Department d")
	List<Department> findBasicDeptInfo();

}
