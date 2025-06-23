package com.petlog.petlog.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {
    public static MongoClient mongoClient;

    static {
        try {
            // Ganti URI sesuai MongoDB kamu
            String uri = "mongodb://localhost:27017";
            mongoClient = MongoClients.create(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MongoDatabase getDatabase(String dbName) {
        if (mongoClient == null) {
            throw new IllegalStateException("MongoClient not initialized!");
        }
        return mongoClient.getDatabase(dbName);
    }
}
