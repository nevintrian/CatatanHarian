package com.example.catatanharian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class SignUpActivity extends AppCompatActivity {

    EditText username, password, ulangiPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Registrasi");
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
        ulangiPassword = findViewById(R.id.edt_ulangi_password);
    }

    public void actionLoginDisini(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void actionDaftar(View view) {
        if(password.getText().toString().equals(ulangiPassword.getText().toString())){
            String isiFile =
                    username.getText().toString() + ";" +
                    password.getText().toString();

            File file = new File(getFilesDir(), username.getText().toString());
            FileOutputStream outputStream = null;
            try{
                file.createNewFile();
                outputStream = new FileOutputStream(file, false);
                outputStream.write(isiFile.getBytes());
                outputStream.flush();
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            Toast.makeText(this, "Berhasil daftar, silahkan login", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,LoginActivity.class));
        }else{
            Toast.makeText(this, "Password yang diisikan tidak sama", Toast.LENGTH_SHORT).show();
        }

    }
}