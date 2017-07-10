package businessLogic;

import util.JdbcUtil;

import employment.Employee;
import employment.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.*;

public class EmployeeService {
	
	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("employee-department-pu");
	
	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void insertEmployee(String firstName, String lastName, int age, int deptId) {
		EntityManager entityMgr = EMF.createEntityManager();
		entityMgr.getTransaction().begin();
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setAge(age);
		employee.setDepartment(entityMgr.find(Department.class, deptId));
		entityMgr.persist(employee);
		entityMgr.getTransaction().commit();
		entityMgr.close();

		
	}
		
	
	public static List<Employee> queryEmployee() {
		EntityManager entityMgr = EMF.createEntityManager();
		
		Query query = entityMgr.createQuery("SELECT e FROM Employee e", Employee.class);
		@SuppressWarnings("unchecked")
		List<Employee> empList = query.getResultList();
		
		entityMgr.close();
		
		return empList;
			
	}

}
