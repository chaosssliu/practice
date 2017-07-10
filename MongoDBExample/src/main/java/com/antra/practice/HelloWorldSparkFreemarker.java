package com.antra.practice;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkFreemarker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldSparkFreemarker.class, "/");
		
		Spark.get("/", new Route() {
			public Object handle(final Request request, final Response response) {
				StringWriter writer = new StringWriter();
				try {
					Template helloTemplate = configuration.getTemplate("hello.ftl");
					Map<String, Object> helloMap = new HashMap<>();
					helloMap.put("name", "Freemarker");
					helloMap.put("age", 20);
					
					helloTemplate.process(helloMap, writer);		
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return writer;
			}
		});
	}

}
