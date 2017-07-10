/**
 * 
 */
package com.steven.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author yumingwei
 * @Date Mar 21, 2017 
 * @Desc: 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HelloControllerTest {

	private String url = "/say";
	private int id = 1;
	
	@Autowired
	private MockMvc mvc;
	
	public HelloControllerTest() {
		
	}

	@Test
	public void testSayHello() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get(url))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
			.andReturn().equals("sayHello Service");
	}
	
	@Test
	public void testSayHelloWithId() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get(url + "/" + id))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn().equals("Hello " + id);
	}

}


