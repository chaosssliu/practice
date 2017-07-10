package com.antra.sergeymsg;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;

public class UpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("db");
		MongoCollection<Document> collection = db.getCollection("updateTest");
		
		collection.drop();
		
		for (int i = 0; i < 10; i++) {
			collection.insertOne(new Document().append("_id", i).append("x", i));
		}
		
//		collection.replaceOne(Filters.eq("x", 5), new Document()
//				.append("id", 5)
//				.append("x", 20)
//				.append("update", true));
		
//		collection.updateOne(Filters.eq("x", 5), new Document("$set", new Document("x", 20)));
		
//		collection.updateOne(Filters.eq("_id", 9), new Document("$set", new Document("x", 20)), new UpdateOptions().upsert(true));
		
		collection.updateMany(Filters.gte("_id", 5), new Document("$inc", new Document("x", 1)));
		
		for (Document cur : collection.find().into(new ArrayList<Document>())) {
			// printJson(cur);
		}
	}

}
