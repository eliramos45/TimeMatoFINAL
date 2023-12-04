package com.example.timemato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class estadisticas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        Button btnRegresarDeStats = findViewById(R.id.btnRegresarDeStats);
        ImageView userProfilePic = findViewById(R.id.userProfilePic);

        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(estadisticas.this, perfil.class);
                startActivity(intento);
            }
        });

        btnRegresarDeStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(estadisticas.this, perfil.class);
                startActivity(intento);
            }
        });
    }
}