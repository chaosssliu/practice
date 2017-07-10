package com.antra.practice;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class FruitSpark {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(FruitSpark.class, "/");
		
		Spark.get("/", new Route() {
			public Object handle(final Request request, final Response response) {
				
				try {
					Map<String, Object> fruitsMap = new HashMap<>();
					fruitsMap.put("fruits", Arrays.asList("apple", "orange", "banana", "pear"));
					Template fruitPickerTemplate = configuration.getTemplate("fruitPicker.ftl");
					StringWriter writer = new StringWriter();
					fruitPickerTemplate.process(fruitsMap, writer);
					return writer;
				} catch (Exception e) {
//					halt(500);
					return null;
				}
			}
		});
		
		Spark.post("/favorite_fruit", new Route() {
			public Object handle(final Request request, final Response response) {
				final String fruit = request.queryParams("fruit");
				if (fruit == null) {
					return "pick one";
				} else {
					return "your favorite fruit is " + fruit;
				}
			}
		});
	}

}
