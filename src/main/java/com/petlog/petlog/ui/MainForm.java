package com.petlog.petlog.ui;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {

    public MainForm() {
        setTitle("PetLog - Dashboard Utama");
        setSize(600, 400);
        setLocationRelativeTo(null); // Pusat layar
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // Manual layout

        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(230, 230, 250)); // Lavender background
        mainPanel.setBounds(0, 0, 600, 400);
        add(mainPanel);

        // Label judul
        JLabel welcomeLabel = new JLabel("Welcome to PetLog!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setBounds(180, 40, 300, 30);
        mainPanel.add(welcomeLabel);

        // Tombol fitur 1
        JButton btnVaksin = new JButton("Jadwal Vaksin");
        btnVaksin.setBounds(200, 100, 200, 40);
        mainPanel.add(btnVaksin);

        // Tombol fitur 2
        JButton btnMakan = new JButton("Pengingat Makanan");
        btnMakan.setBounds(200, 160, 200, 40);
        mainPanel.add(btnMakan);

        // Tombol fitur 3
        JButton btnDokter = new JButton("Kontrol Dokter Hewan");
        btnDokter.setBounds(200, 220, 200, 40);
        mainPanel.add(btnDokter);

        // Tombol logout
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(450, 20, 100, 30);
        mainPanel.add(btnLogout);

        // Event Logout
        btnLogout.addActionListener(e -> {
            dispose();
            new LoginForm(new java.util.Locale("en", "US")); // Kembali ke login
        });
    }

    // Agar bisa dijalankan langsung
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainForm().setVisible(true);
        });
    }
}
