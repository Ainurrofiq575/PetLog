/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlog.petlog.service;


import com.petlog.petlog.service.MongoDBConnect;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public class BackupService {
    
    public static void backupCollection(String collectionName, String outputPath) {
        MongoCollection<Document> collection = MongoDBConnect.getCollection(collectionName);

        try (MongoCursor<Document> cursor = collection.find().iterator();
             FileWriter writer = new FileWriter(outputPath)) {

            writer.write("[\n");
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                writer.write(doc.toJson());

                if (cursor.hasNext()) {
                    writer.write(",\n");
                }
            }
            writer.write("\n]");

            System.out.println("✅ Backup selesai: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void backupAll() {
        backupCollection("catatan_perawatan", "backup_catatan.json");
        backupCollection("jadwal_vaksin", "backup_vaksin.json");
        backupCollection("data_hewan", "backup_hewan.json");
    }
}
