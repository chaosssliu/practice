package net.antra.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import net.antra.deptemp.dao.DepartmentDAO;
import net.antra.deptemp.entity.Department;
import net.antra.deptemp.service.DepartmentServiceImpl;

public class UnitTest_5Spring_Mockito {
	
	@Mock
    private DepartmentDAO deptDao;
	
	@Before
    public void setupMock() {
       MockitoAnnotations.initMocks(this);
    }
	
    @Test
    public void testMockGet(){
    		List<Department> resList = new ArrayList<Department>();
    		resList.add(new Department());
    		resList.add(new Department());
		
    		when(deptDao.findAllDepartments()).thenReturn(resList);
		
		
	    assertEquals(2,deptDao.findAllDepartments().size());
    }
    
    @Test(expected = RuntimeException.class)
    public void testMockSave(){
		doThrow(new SQLException()).when(deptDao).save(anyObject());
		DepartmentServiceImpl ds = new DepartmentServiceImpl();
		ds.setDeptDAO(deptDao);
		ds.saveDept(new Department());
    }
    
    @Test
    public void testMockSaveGood(){
		//doNothing().when(deptDao).save(new Department());
    	
		doAnswer(new Answer<Void>() {
		    public Void answer(InvocationOnMock invocation) {
		      Object[] args = invocation.getArguments();
		      System.out.println("called save with arguments: " + Arrays.toString(args));
		      return null;
		    }
		}).when(deptDao).save(anyObject());
		
		
		DepartmentServiceImpl ds = new DepartmentServiceImpl();
		ds.setDeptDAO(deptDao);
		Department dept = new Department();
		dept.setName("AnotherTestDept");
		ds.saveDept(dept);
    }
    
}
