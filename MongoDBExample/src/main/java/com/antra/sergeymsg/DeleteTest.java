package com.antra.sergeymsg;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DeleteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("db");
		MongoCollection<Document> collection = db.getCollection("deleteTest");
		
		collection.drop();
		
		for (int i = 0; i < 8; i++) {
			collection.insertOne(new Document().append("_id", i));
		}
		
		collection.deleteMany(Filters.gt("_id", 4));
		
		for (Document cur : collection.find().into(new ArrayList<Document>())) {
			// printJson(cur);
		}
	}

}
