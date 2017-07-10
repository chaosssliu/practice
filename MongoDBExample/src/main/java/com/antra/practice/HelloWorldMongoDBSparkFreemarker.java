package com.antra.practice;

import java.io.StringWriter;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldMongoDBSparkFreemarker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldMongoDBSparkFreemarker.class, "/");
		
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("db");
		final MongoCollection<Document> collection = db.getCollection("hello");
		
		collection.drop();
		
		collection.insertOne(new Document("name", "MongoDB"));
		
		Spark.get("/", new Route() {
			public Object handle(final Request request, final Response response) {
				StringWriter writer = new StringWriter();
				try {
					Template helloTemplate = configuration.getTemplate("hello.ftl");
					
					Document document = collection.find().first();
					
					helloTemplate.process(document, writer);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return writer;
			}
		});
	}

}
