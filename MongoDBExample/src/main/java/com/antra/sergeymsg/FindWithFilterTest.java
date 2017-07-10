package com.antra.sergeymsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import static com.mongodb.client.model.Filters.*;

public class FindWithFilterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("db");
		MongoCollection<Document> collection = db.getCollection("findWithFilterTest");
		
		collection.drop();
		
		for (int i = 0; i < 10; i++) {
			collection.insertOne(new Document()
					.append("x", new Random().nextInt(2))
					.append("y", new Random().nextInt(100))
					.append("i", i));
		}
		
//		Bson filter = new Document("x", 0)
//				.append("y", new Document("$gt", 10).append("$lt", 90));
		
		// include x = 0
		Bson filter = and(eq("x", 0), gt("y", 10), lt("y", 90));
		
		// exclude x = 0 and "_id"
		// don't show "x" and "_id"
		Bson projection = new Document("x", 0)
				.append("_id", 0);
		
//		Bson projection = Projections.exclude("x", "_id");
		
		// include "y" and "i", but exclude "_id"
		// since "_id" will be shown by default
//		Bson projection = Projections.fields(Projections.include("y", "i"), Projections.exclude("_id"));
		
//		Bson projection = new Document("y", 1)
//				.append("i", 1)
//				.append("_id", 0);
// since "_id" will be shown by default
		
		List<Document> all = collection.find(filter)
				.projection(projection)
				.into(new ArrayList<Document>());
		
		for (Document cur : all) {
			// printJson(cur);
		}
		
		long count = collection.count(filter);
		System.out.println();
		System.out.println(count);
	}

}
