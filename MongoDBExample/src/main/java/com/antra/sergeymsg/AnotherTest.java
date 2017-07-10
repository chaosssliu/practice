package com.antra.sergeymsg;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class AnotherTest {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("db");
		MongoCollection<Document> collection = db.getCollection("test");
		
		collection.drop();
		
		for (int i = 0; i < 10; i++) {
			collection.insertOne(new Document("x", i));
		}
		
		// find the first one
		Document first = collection.find().first();
		
		// find all with into
		List<Document> all = collection.find().into(new ArrayList<Document>());
		
		// find all with iteration
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document cur = cursor.next();
				// printJson(cur);
			}
		} finally {
			cursor.close();
		}
		
		// count
		long count = collection.count();
	}
}
