package businessLogic;

import util.JdbcUtil;
import employment.Department;
import employment.Employee;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class DepartmentService {
	
	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("employee-department-pu");
	
	public DepartmentService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void insertDepartment(String deptName, String deptEmail) {
		EntityManager entityMgr = EMF.createEntityManager();
		entityMgr.getTransaction().begin();
		Department department = new Department();
		department.setName(deptName);
		department.setEmail(deptEmail);
		entityMgr.persist(department);
		entityMgr.getTransaction().commit();
		entityMgr.close();

	}
	

	public static List<Department> queryDepartment() {
			EntityManager entityMgr = EMF.createEntityManager();
			Query query = entityMgr.createQuery("SELECT d FROM Department d", Department.class);
			@SuppressWarnings("unchecked")
			List<Department> deptList = query.getResultList();
			entityMgr.close();
			return deptList;
	}
	

}
