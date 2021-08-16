package com.example.catatanharian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
    }

    public void actionNote(View view){
        Intent intent = new Intent(this, DailyNoteActivity.class);
        intent.putExtra(GlobalVariable.CATATAN_HARIAN, "Catatan Harian");
        startActivity(intent);
    }

    public void actionLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(GlobalVariable.LOGIN, "login");
        startActivity(intent);
    }

}