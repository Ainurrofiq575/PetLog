/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlog.petlog.service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.petlog.petlog.service.MongoDBConnect;
import org.bson.Document;
import org.bson.types.ObjectId;

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

    public static void updateNama(String id, String newNama) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void delete(String id) {
        MongoCollection<Document> col = MongoDBConnect.getCollection("data_hewan");
        col.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
public static void update(String id, String nama, String jenis, String usia, String ras, String catatan) {
    MongoCollection<Document> col = MongoDBConnect.getCollection("data_hewan");

    col.updateOne(
        Filters.eq("_id", new ObjectId(id)),
        Updates.combine(
            Updates.set("nama", nama),
            Updates.set("jenis", jenis),
            Updates.set("usia", usia),
            Updates.set("ras", ras),
            Updates.set("catatan", catatan)
        )
    );
}

}
