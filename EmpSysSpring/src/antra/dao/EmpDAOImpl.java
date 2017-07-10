package antra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import antra.entity.Employee;
import antra.entity.Department;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@PersistenceContext
	EntityManager entityMgr;
	
	@Override
	public void insert(String firstName, String lastName, Integer age, Integer department) {
		Employee employee= new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setAge(age);
		employee.setDepartment(entityMgr.find(Department.class, department));		
		entityMgr.persist(employee);

	}

	@Override
	public List<Employee> queryEmployee() {
		Query query = entityMgr.createQuery("SELECT DISTINCT OBJECT(e) FROM Employee e");
		@SuppressWarnings("unchecked")
		List<Employee> empList = query.getResultList();
		return empList;
	}
	
	@Override
	public void deleteEmpById(Integer id) {
		Employee employee = entityMgr.find(Employee.class, id);
		entityMgr.remove(employee);
	}

}
