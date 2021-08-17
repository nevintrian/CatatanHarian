package com.example.catatanharian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
    }

    public void actionDaftarDisini(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    public void actionLogin(View view) {

        if (username.getText().toString().isEmpty()) {
            Toast.makeText(this, "Username belum diisi", Toast.LENGTH_SHORT).show();
        } else if (password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Password belum diisi", Toast.LENGTH_SHORT).show();
        } else {
            File sdcard = getFilesDir();
            File file = new File(sdcard, username.getText().toString());
            if (file.exists()) {
                StringBuilder text = new StringBuilder();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line = br.readLine();
                    while (line != null) {
                        text.append(line);
                        line = br.readLine();
                    }
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error " + e.getMessage());
                }
                String data = text.toString();
                String[] dataUser = data.split(";");

                if (dataUser[1].equals(password.getText().toString())) {
                    startActivity(new Intent(this, MainActivity.class));
                    Toast.makeText(this, "Berhasil login", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Password tidak sesuai", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Username tidak ditemukan", Toast.LENGTH_SHORT).show();
            }
        }
    }
}