package net.antra.deptemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.antra.deptemp.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Employee> getEmployeeList() {
		Query query = em.createQuery("select DISTINCT OBJECT(e) from Employee e ");
		return query.getResultList();
	}
}
