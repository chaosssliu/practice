package com.antra.sergeymsg;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Sorts.*;

import static com.mongodb.client.model.Projections.*;

import java.util.ArrayList;
import java.util.List;

public class FindWithSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("db");
		MongoCollection<Document> collection = db.getCollection("findWithSortTest");
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				collection.insertOne(new Document().append("i", i).append("j", j));
			}
		}
		
		Bson projection = fields(include("i", "j"), excludeId());
		
//		Bson sort = new Document("i", 1).append("j", -1);
		
		Bson sort = orderBy(ascending("i"), descending("j"));
		
//		Bson sort = descending("j", "i");
		
		List<Document> all = collection
				.find()
				.projection(projection)
				.sort(sort)
				.skip(20)
				.limit(15)
				.into(new ArrayList<Document>());
		
		for (Document cur : all) {
			// printJson(cur);
		}
	}

}
