package antra.dao;

import antra.entity.Department;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DeptDAOImpl implements DeptDAO {
	
	@PersistenceContext
	EntityManager entityMgr;

	@Override
	public void insert(Department department) {
		entityMgr.persist(department);

	}

	@Override
	public List<Department> queryDepartment() {
		Query query = entityMgr.createQuery("SELECT DISTINCT OBJECT(d) FROM Department d LEFT JOIN FETCH d.empList");
		@SuppressWarnings("unchecked")
		List<Department> deptList = query.getResultList();
		return deptList;
	}

}
