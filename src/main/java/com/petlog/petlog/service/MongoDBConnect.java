/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlog.petlog.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author LENOVO
 */
public class MongoDBConnect {

    private static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private static MongoDatabase database = mongoClient.getDatabase("petlog"); // Ganti sesuai nama database kamu

    public static MongoCollection<Document> getCollection(String name) {
        return database.getCollection(name);
    }
}
