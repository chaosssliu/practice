package net.antra.springdata.test;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.antra.springdata.entity.Employee;
import net.antra.springdata.entity.TestEmp;
import net.antra.springdata.service.DepartmentService;
import net.antra.springdata.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class MainTest {
 	@Autowired
    private TestRestTemplate restTemplate;
 	
 	@Autowired
	DepartmentService dService;
 	
 	@Autowired
	EmployeeService empService;
 	
 	@Test
    public void testE() {
 		Employee emp = empService.findEmpByFirstNameAndLastName("Dawei","Zhuang");
 		System.out.println(emp.getFirstName());
 		assertTrue(emp.getFirstName().equals("Dawei"));
 	}
 	
    @Test
    @Ignore
    public void test() {
    		TestEmp emp = this.restTemplate.getForEntity("/emp", TestEmp.class).getBody();
    }

}
