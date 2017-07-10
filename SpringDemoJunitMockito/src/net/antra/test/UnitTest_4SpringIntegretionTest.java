package net.antra.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import net.antra.deptemp.config.MvcConfig;
import net.antra.deptemp.config.PersistenceJPAConfig;
import net.antra.deptemp.entity.Department;
import net.antra.deptemp.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class,PersistenceJPAConfig.class})
@WebAppConfiguration
public class UnitTest_4SpringIntegretionTest {
	
	@Autowired
	DepartmentService deptService;
	
	
	@Test
	public void testDeptService(){
		List<Department> list = deptService.loadDeptBasicInfo();
		list.forEach(System.out::println);
		assertTrue(!list.isEmpty());
	}
	
	@Test(expected=Exception.class)
	public void testDeptServiceSave(){
		Department dept = new Department();
		dept.setName("Test_Dept");
		deptService.saveDept(dept);
		//assertTrue(true);
	}
}
