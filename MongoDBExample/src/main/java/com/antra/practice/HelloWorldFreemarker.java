package com.antra.practice;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFreemarker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldFreemarker.class, "/");
		
		try {
			Template helloTemplate = configuration.getTemplate("hello.ftl");
			StringWriter writer = new StringWriter();
			Map<String, Object> helloMap = new HashMap<>();
			helloMap.put("name", "Freemarker");
			helloMap.put("age", 20);
			
			helloTemplate.process(helloMap, writer);
			System.out.println(writer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
