package com.petlog.petlog.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class UserService {
    public static boolean checkLogin(String username, String password) {
        MongoDatabase db = MongoUtil.getDatabase("petlog");
        MongoCollection<Document> users = db.getCollection("users");

        Document user = users.find(new Document("username", username)
                                        .append("password", password)).first();

        return user != null;
    }
}
