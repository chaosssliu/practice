package com.antra.practice;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSpark {

	public static void main(String[] args) {
		Spark.get("/", new Route() {
			public Object handle(final Request request, final Response response) {
				return "Hello World Spark";
			}
		});
	}
}
