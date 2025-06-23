package com.petlog.petlog.ui;

import com.petlog.petlog.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginForm extends JFrame {
    private ResourceBundle bundle;

    public LoginForm(Locale locale) {
        bundle = ResourceBundle.getBundle("messages", locale);
        setTitle(bundle.getString("app.title"));
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // Manual layout untuk desain bebas

        // Panel utama (background abu-abu)
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(Color.LIGHT_GRAY);
        backgroundPanel.setBounds(0, 0, 600, 400);
        add(backgroundPanel);

        // Combo box untuk pilih bahasa
        JLabel languageLabel = new JLabel("Choose Language :");
        languageLabel.setBounds(380, 20, 120, 25);
        backgroundPanel.add(languageLabel);

        JComboBox<String> languageCombo = new JComboBox<>(new String[]{"English", "Bahasa Indonesia"});
        languageCombo.setBounds(490, 20, 90, 25);
        backgroundPanel.add(languageCombo);

        // Panel hitam di tengah
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.BLACK);
        formPanel.setBounds(80, 70, 450, 230);
        backgroundPanel.add(formPanel);

        // Label Username
        JLabel userLabel = new JLabel(bundle.getString("label.username"));
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(40, 30, 100, 25);
        formPanel.add(userLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 30, 250, 25);
        formPanel.add(usernameField);

        // Label Password
        JLabel passLabel = new JLabel(bundle.getString("label.password"));
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(40, 70, 100, 25);
        formPanel.add(passLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 250, 25);
        formPanel.add(passwordField);

        // Tombol Login
        JButton loginButton = new JButton(bundle.getString("button.login"));
        loginButton.setBounds(300, 110, 100, 30);
        formPanel.add(loginButton);

        // Label Forgot Password
        JLabel forgotLabel = new JLabel("Forgot Password ?");
        forgotLabel.setForeground(Color.WHITE);
        forgotLabel.setBounds(40, 170, 150, 25);
        formPanel.add(forgotLabel);

        // Aksi Login
        loginButton.addActionListener((ActionEvent e) -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (UserService.checkLogin(user, pass)) {
                JOptionPane.showMessageDialog(this, bundle.getString("message.login.success"));
                dispose(); // Tutup login
                new Dashboard().setVisible(true); // Ganti dengan form utama
            } else {
                JOptionPane.showMessageDialog(this, bundle.getString("message.login.fail"));
            }
        });

        // Ganti bahasa dari combo box
        languageCombo.addActionListener(e -> {
            Locale selectedLocale = languageCombo.getSelectedIndex() == 0 ? new Locale("en", "US") : new Locale("id", "ID");
            dispose();
            new LoginForm(selectedLocale);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm(new Locale("en", "US")); // Default Inggris
    }
}
