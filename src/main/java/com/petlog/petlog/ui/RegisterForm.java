/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlog.petlog.ui;

import com.petlog.petlog.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author LENOVO
 */
public class RegisterForm extends JFrame{
    public RegisterForm() {
        setTitle("🐾 Register - PetLog");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        Color lightBrown = new Color(234, 213, 194);
        Color darkBrown = new Color(90, 56, 36);
        Color accent = new Color(255, 153, 102);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(darkBrown);
        panel.setBounds(0, 0, 400, 350);
        add(panel);

        JLabel titleLabel = new JLabel("Daftar Akun Baru", JLabel.CENTER);
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(50, 20, 300, 30);
        panel.add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 70, 100, 25);
        userLabel.setForeground(Color.WHITE);
        panel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 70, 180, 25);
        panel.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 110, 100, 25);
        passLabel.setForeground(Color.WHITE);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 180, 25);
        panel.add(passField);

        JLabel confirmLabel = new JLabel("Konfirmasi Password:");
        confirmLabel.setBounds(50, 150, 150, 25);
        confirmLabel.setForeground(Color.WHITE);
        panel.add(confirmLabel);

        JPasswordField confirmField = new JPasswordField();
        confirmField.setBounds(200, 150, 130, 25);
        panel.add(confirmField);

        JButton registerButton = new JButton("Daftar");
        registerButton.setBounds(150, 200, 100, 30);
        registerButton.setBackground(accent);
        registerButton.setForeground(Color.WHITE);
        panel.add(registerButton);

        registerButton.addActionListener((ActionEvent e) -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            String confirm = new String(confirmField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username dan password tidak boleh kosong.");
                return;
            }

            if (!password.equals(confirm)) {
                JOptionPane.showMessageDialog(this, "Konfirmasi password tidak cocok.");
                return;
            }

            if (UserService.usernameExists(username)) {
                JOptionPane.showMessageDialog(this, "Username sudah digunakan. Coba yang lain.");
                return;
            }

            UserService.register(username, password);
            JOptionPane.showMessageDialog(this, "✅ Pendaftaran berhasil. Silakan login.");
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterForm();
    }
}
