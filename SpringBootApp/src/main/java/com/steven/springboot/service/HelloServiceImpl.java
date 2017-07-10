/**
 * 
 */
package com.steven.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @author yumingwei
 * @Date Mar 21, 2017 
 * @Desc: 
 */
@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello() {
		System.out.println("sayHello Service");
		return "sayHello Service";
	}
	
}
