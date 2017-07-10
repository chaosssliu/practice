package net.antra.test.mock;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import net.antra.deptemp.entity.Department;

@Repository
public class SimpleDAOImpl implements SimpleDAO{

	@PersistenceContext 
	EntityManager em;
	
	@Override
	public void save(Department dept) {
		em.persist(dept); 
	}
	
}
