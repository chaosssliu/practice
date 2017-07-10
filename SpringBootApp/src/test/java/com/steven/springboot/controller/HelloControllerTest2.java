/**
 * 
 */
package com.steven.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.steven.springboot.service.HelloService;

/**
 * @author yumingwei
 * @Date Mar 21, 2017 
 * @Desc: 
 */

public class HelloControllerTest2 {

	@Mock
	HelloService helloService;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSayHello() {
		when(helloService.sayHello()).thenReturn("sayHello Service");
		assertEquals("sayHello Service",helloService.sayHello());
		
	}
	
	@Test(expected=RuntimeException.class, timeout=10000)
	public void throwError() {
		doThrow(RuntimeException.class).when(helloService.sayHello());
		helloService.sayHello();
	}
}







