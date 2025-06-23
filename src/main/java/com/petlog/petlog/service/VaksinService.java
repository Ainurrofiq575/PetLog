/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlog.petlog.service;

import com.petlog.petlog.service.MongoDBConnect;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author LENOVO
 */
public class VaksinService {

    public static void simpan(String namaHewan, String namaVaksin, String tanggal) {
        MongoCollection<Document> collection = MongoDBConnect.getCollection("jadwal_vaksin");

        Document doc = new Document()
                .append("namaHewan", namaHewan)
                .append("namaVaksin", namaVaksin)
                .append("tanggal", tanggal);

        collection.insertOne(doc);
    }

    // ✅ Tambahkan fungsi UPDATE di sini
    public static void update(String id, String namaHewan, String namaVaksin, String tanggal) {
        MongoCollection<Document> col = MongoDBConnect.getCollection("jadwal_vaksin");
        ObjectId objId = new ObjectId(id);

        Document updateDoc = new Document("$set", new Document()
                .append("namaHewan", namaHewan)
                .append("namaVaksin", namaVaksin)
                .append("tanggal", tanggal));

        col.updateOne(new Document("_id", objId), updateDoc);
    }

    // Fungsi hapus kalau kamu pakai
    public static void hapus(String id) {
        MongoCollection<Document> col = MongoDBConnect.getCollection("jadwal_vaksin");
        col.deleteOne(new Document("_id", new ObjectId(id)));
    }

}
