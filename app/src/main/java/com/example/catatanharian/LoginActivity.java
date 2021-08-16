package com.example.catatanharian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        if(username.getText().toString().isEmpty()){
            Toast.makeText(this, "Username belum diisi", Toast.LENGTH_SHORT).show();
        }else if(password.getText().toString().isEmpty()){
            Toast.makeText(this, "Password belum diisi", Toast.LENGTH_SHORT).show();
        }else if(username.getText().toString().equals("nevin") && password.getText().toString().equals("nevin123")){
            startActivity(new Intent(this,MainActivity.class));
            Toast.makeText(this, "Berhasil login", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "username atau password salah", Toast.LENGTH_SHORT).show();
        }
    }
}