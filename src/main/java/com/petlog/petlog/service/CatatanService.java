/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlog.petlog.service;

import com.mongodb.client.MongoCollection;
import com.petlog.petlog.service.MongoDBConnect;
import org.bson.Document;
import org.bson.types.ObjectId;

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

    public static void updateCatatan(String id, String jenis, String tanggal, String catatan) {
    MongoCollection<Document> col = MongoDBConnect.getCollection("catatan_perawatan");
    ObjectId objId = new ObjectId(id);

    Document updateDoc = new Document("$set", new Document()
        .append("jenis", jenis)
        .append("tanggal", tanggal)
        .append("catatan", catatan));

    col.updateOne(new Document("_id", objId), updateDoc);}

    public static void delete(String id) {
        MongoCollection<Document> col = MongoDBConnect.getCollection("catatan_perawatan");
        ObjectId objId = new ObjectId(id);
        col.deleteOne(new Document("_id", objId));
    }

    public static void update(String id, String jenis, String tanggal, String catatan) {
    MongoCollection<Document> col = MongoDBConnect.getCollection("catatan");

    Document updateDoc = new Document("$set", new Document()
            .append("jenisPerawatan", jenis)
            .append("tanggal", tanggal)
            .append("catatanTambahan", catatan));

    col.updateOne(new Document("_id", new ObjectId(id)), updateDoc);}
}
