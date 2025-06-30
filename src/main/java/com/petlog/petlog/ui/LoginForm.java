package com.petlog.petlog.ui;

import com.petlog.petlog.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginForm extends JFrame {
    private ResourceBundle bundle;

    public LoginForm(Locale locale) {
        bundle = ResourceBundle.getBundle("messages", locale);
        setTitle(bundle.getString("app.title"));
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Color lightBrown = new Color(234, 213, 194);
        Color darkBrown = new Color(90, 56, 36);
        Color accent = new Color(255, 153, 102);

        // Background panel utama
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(lightBrown);
        backgroundPanel.setBounds(0, 0, 700, 400);
        add(backgroundPanel);

        // Panel kiri untuk gambar
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 350, 400);
        leftPanel.setBackground(lightBrown);
        leftPanel.setLayout(new BorderLayout());

        // Gambar hewan
        URL iconUrl = getClass().getResource("/img/pet-icon.png");
        if (iconUrl != null) {
            JLabel imageLabel = new JLabel(new ImageIcon(iconUrl));
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            leftPanel.add(imageLabel, BorderLayout.CENTER);
        } else {
            JLabel placeholder = new JLabel("🐾 Pet App", JLabel.CENTER);
            placeholder.setFont(new Font("Poppins", Font.BOLD, 24));
            leftPanel.add(placeholder, BorderLayout.CENTER);
        }
        backgroundPanel.add(leftPanel);

        // Panel kanan untuk form login
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(darkBrown);
        formPanel.setBounds(350, 0, 350, 400);
        backgroundPanel.add(formPanel);

        // Label bahasa
        JLabel languageLabel = new JLabel("🌐 Language:");
        languageLabel.setForeground(Color.WHITE);
        languageLabel.setBounds(200, 10, 100, 25);
        formPanel.add(languageLabel);

        JComboBox<String> languageCombo = new JComboBox<>(new String[]{"English", "Bahasa Indonesia"});
        languageCombo.setBounds(200, 35, 130, 25);
        formPanel.add(languageCombo);

        // Atur ComboBox sesuai locale saat ini
        if (locale.getLanguage().equals("id")) {
            languageCombo.setSelectedIndex(1);
        } else {
            languageCombo.setSelectedIndex(0);
        }

        // Username
        JLabel userLabel = new JLabel(bundle.getString("label.username"));
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        userLabel.setBounds(40, 90, 100, 25);
        formPanel.add(userLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(40, 115, 260, 30);
        usernameField.setBackground(Color.WHITE);
        formPanel.add(usernameField);

        // Password
        JLabel passLabel = new JLabel(bundle.getString("label.password"));
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        passLabel.setBounds(40, 160, 100, 25);
        formPanel.add(passLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(40, 185, 260, 30);
        passwordField.setBackground(Color.WHITE);
        formPanel.add(passwordField);

        // Tombol Login
        JButton loginButton = new JButton(bundle.getString("button.login"));
        loginButton.setBounds(200, 230, 100, 35);
        loginButton.setBackground(accent);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        formPanel.add(loginButton);

        // Tombol Register
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(40, 230, 100, 35);
        registerButton.setBackground(accent);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        formPanel.add(registerButton);

        // Aksi klik tombol register
        registerButton.addActionListener((ActionEvent e) -> {
            new RegisterForm();
        });

        // Lupa Password
        JLabel forgotLabel = new JLabel("🔒 Forgot Password?");
        forgotLabel.setForeground(Color.WHITE);
        forgotLabel.setFont(new Font("Poppins", Font.ITALIC, 12));
        forgotLabel.setBounds(40, 280, 200, 25);
        formPanel.add(forgotLabel);

        // Aksi login
        loginButton.addActionListener((ActionEvent e) -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (UserService.checkLoginHashed(user, pass)) {
                JOptionPane.showMessageDialog(this, bundle.getString("message.login.success"));
                dispose();
                new Dashboard().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, bundle.getString("message.login.fail"));
            }
        });

        // Aksi ganti bahasa
        languageCombo.addActionListener(e -> {
            Locale selectedLocale = languageCombo.getSelectedIndex() == 0
                ? new Locale("en", "US")
                : new Locale("id", "ID");
            dispose(); // Tutup jendela sekarang
            new LoginForm(selectedLocale); // Buka baru dengan locale baru
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm(new Locale("en", "US"));
    }

}
