/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlog.petlog.service;
import com.mongodb.client.MongoCollection;
import com.petlog.petlog.service.MongoDBConnect;
import org.bson.Document;

/**
 *
 * @author LENOVO
 */
public class HewanService {
        public static void simpan(String nama, String jenis, String usia, String ras, String catatan) {
        MongoCollection<Document> collection = MongoDBConnect.getCollection("data_hewan");

        Document doc = new Document()
                .append("nama", nama)
                .append("jenis", jenis)
                .append("usia", usia)
                .append("ras", ras)
                .append("catatan", catatan);

        collection.insertOne(doc);
    }
}
