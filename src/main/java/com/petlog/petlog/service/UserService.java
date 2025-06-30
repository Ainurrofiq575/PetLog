package com.petlog.petlog.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.petlog.petlog.util.PasswordUtil;

public class UserService {

    // ✅ Tetap dipakai untuk user lama (tanpa hash)
    public static boolean checkLogin(String username, String password) {
        MongoDatabase db = MongoUtil.getDatabase("petlog");
        MongoCollection<Document> users = db.getCollection("users");

        Document user = users.find(new Document("username", username)
                                        .append("password", password)).first();

        return user != null;
    }

    // ✅ Tambahan untuk sistem baru (dengan hashing)
    public static boolean checkLoginHashed(String username, String inputPassword) {
        MongoDatabase db = MongoUtil.getDatabase("petlog");
        MongoCollection<Document> users = db.getCollection("users");

        Document user = users.find(new Document("username", username)).first();
        if (user == null) return false;

        String storedHash = user.getString("password");
        return PasswordUtil.verifyPassword(inputPassword, storedHash);
    }

    // ✅ Tambahan untuk mendaftarkan user baru dengan hash
    public static void register(String username, String plainPassword) {
        MongoDatabase db = MongoUtil.getDatabase("petlog");
        MongoCollection<Document> users = db.getCollection("users");

        String hashed = PasswordUtil.encryptPassword(plainPassword);

        Document newUser = new Document("username", username)
                                .append("password", hashed);
        users.insertOne(newUser);
    }
    
    public static boolean usernameExists(String username) {
    MongoDatabase db = MongoUtil.getDatabase("petlog");
    MongoCollection<Document> users = db.getCollection("users");

    Document existingUser = users.find(new Document("username", username)).first();
    return existingUser != null;
}


}



