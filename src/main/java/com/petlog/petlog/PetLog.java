package com.petlog.petlog;

import com.petlog.petlog.ui.LoginForm;
import java.util.Locale;

public class PetLog {

    public static void main(String[] args) {
        // Ganti ke Bahasa Indonesia jika ingin
        Locale locale = new Locale("en", "US");

        // Tampilkan form login
        new LoginForm(locale);
    }
}
