package com.example.lab4_calcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void OnClickTecnic(View view) {
        Intent intent = new Intent(Menu.this, Tecnic.class);

        startActivity(intent);

    }

    public void OnClickUsual(View view) {
        Intent intent = new Intent(Menu.this, MainActivity.class);

        startActivity(intent);

    }
}