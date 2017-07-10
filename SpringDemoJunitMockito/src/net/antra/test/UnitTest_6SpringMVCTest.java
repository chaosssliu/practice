package net.antra.test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import net.antra.deptemp.config.MvcConfig;
import net.antra.deptemp.config.PersistenceJPAConfig;
import net.antra.deptemp.controller.DeptController;
import net.antra.deptemp.entity.Department;
import net.antra.deptemp.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class,PersistenceJPAConfig.class})
@WebAppConfiguration
public class UnitTest_6SpringMVCTest {
	
	private MockMvc mockMvc;
	 
    @Mock
    private DepartmentService deptServiceMock;
    @InjectMocks
    private DeptController controller;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void test() throws Exception{
    		List<Department> deptList = new ArrayList<>();
    		Department dept = new Department();
    		deptList.add(dept);
    		
    		when(deptServiceMock.loadDeptBasicInfo()).thenReturn(deptList);
//    		.thenAnswer(new Answer<Void>() {
//		    public Void answer(InvocationOnMock invocation) {
//		      Object[] args = invocation.getArguments();
//		      System.out.println("called save with arguments: " + Arrays.toString(args));
//		      return null;
//		    }
//		});
    		
    		mockMvc.perform(get("/viewDept")
    				.param("whatever","1"))
    		.andExpect(status().isOk())
        .andExpect(model().attribute("deptList",deptList))
        .andExpect(view().name("dept"));
    }
}
