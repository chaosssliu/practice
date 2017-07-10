/**
 * 
 */
package com.steven.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.steven.springboot.service.HelloService;

/**
 * @author yumingwei
 * @Date Mar 20, 2017 
 * @Desc: 
 */
@RestController
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/say", method=RequestMethod.GET)
	public String sayHello() {
		return helloService.sayHello();	
	}
	
	@RequestMapping(value="/say/{id}", method=RequestMethod.GET)
	public String sayHello2(@PathVariable String id) {
		return "Hello " + id;
	}
	
}
