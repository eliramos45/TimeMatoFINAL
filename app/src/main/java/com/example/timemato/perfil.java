package com.example.timemato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Button btnCambiarFotoUsuario = findViewById(R.id.btnCambiarFotoUsuario);
        Button btnMostrarStats = findViewById(R.id.btnMostrarStats);
        Button btnRegresarDePerfil = findViewById(R.id.btnRegresarDePerfil);


        btnMostrarStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento0 = new Intent(perfil.this,estadisticas.class);
                startActivity(intento0);
            }
        });
        btnRegresarDePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(perfil.this, menu_principal.class);
                startActivity(intento);
            }
        });

        btnCambiarFotoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(perfil.this, "Aún no disponible", Toast.LENGTH_SHORT).show();
            }
        });
    }
}