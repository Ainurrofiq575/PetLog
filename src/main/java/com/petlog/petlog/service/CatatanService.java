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
public class CatatanService {
        public static void simpan(String jenis, String tanggal, String catatan) {
        MongoCollection<Document> collection = MongoDBConnect.getCollection("catatan_perawatan");

        Document doc = new Document()
            .append("jenis", jenis)
            .append("tanggal", tanggal)
            .append("catatan", catatan);

        collection.insertOne(doc);
    }
}
