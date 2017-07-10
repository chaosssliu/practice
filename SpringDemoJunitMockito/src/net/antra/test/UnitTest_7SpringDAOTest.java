package net.antra.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.antra.deptemp.entity.Department;
import net.antra.test.mock.SimpleDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CustomizedTestContext.class})
public class UnitTest_7SpringDAOTest {
	@Autowired
	SimpleDAO simpleDAO;
	
	@Test
	@Transactional
	public void testDAO(){
		Department department = new Department();
		department.setName("TestDept");
		simpleDAO.save(department);
	}
}
