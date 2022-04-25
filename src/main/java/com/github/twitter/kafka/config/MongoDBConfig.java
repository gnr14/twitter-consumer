package com.github.twitter.kafka.config;

import com.github.twitter.kafka.constants.MongoDB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * MongoDB connection class
 */
public class MongoDBConfig {

    public static MongoCollection<Document> createDBConnection() {

        MongoClientURI uri = new MongoClientURI(MongoDB.URL);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(MongoDB.DB_NAME);

        MongoCollection<Document> collection = database.getCollection(MongoDB.TABLE_NAME);
        return collection;
    }
}
