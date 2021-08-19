package com.example.catatanharian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;

public class InsertAndViewActivity extends AppCompatActivity {
    private String FILE_NAME = "CatatanHarian.txt";
    public static final int REQUEST_CODE_STORAGE = 100;
    EditText catatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_and_view);
        setTitle("Catatan Baru");
        catatan = findViewById(R.id.edt_catatan);
        checkPermissionStorage();
    }

    public void actionSubmitNote(View view){
        String isiFile = catatan.getText().toString() + ";";
        String state = Environment.getExternalStorageState();

        if(!Environment.MEDIA_MOUNTED.equals(state)){
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME);

        FileOutputStream outputStream = null;
        try{
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        Toast.makeText(this, "Catatan berhasil ditambah", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DailyNoteActivity.class));

    }


    private boolean checkPermissionStorage(){
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_STORAGE);
                return false;
            }
        }else{
            return true;
        }
    }
}