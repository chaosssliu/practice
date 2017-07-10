package com.antra.sergeymsg;

import java.util.Arrays;

import org.bson.BsonDocument;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//1		MongoClient mongoClient = new MongoClient("localhost", 27017);
//2		MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017)));
//3		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongo://localhost:27017"));
		
		MongoClientOptions options = new MongoClientOptions.Builder().connectionsPerHost(100).build();
		MongoClient mongoClient = new MongoClient(new ServerAddress(), options);
		
		MongoDatabase db = mongoClient.getDatabase("test").withReadPreference(ReadPreference.secondary());
		
//		MongoCollection<Document> coll = db.getCollection("test");
		
		MongoCollection<BsonDocument> coll = db.getCollection("test", BsonDocument.class);
	}

}
