package com.example.timemato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_opciones);

        ImageView userProfilePic = findViewById(R.id.userProfilePic);

        //Codigo para ir a perfil
        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(opciones.this, perfil.class);
                startActivity(intento);
            }
        });

        //Codigo de menu inferior
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), menu_principal.class));
                return true;
            } else if (item.getItemId() == R.id.bottom_consejos) {
                startActivity(new Intent(getApplicationContext(), consejos.class));
                return true;
            } else if (item.getItemId() == R.id.bottom_cronometro) {
                startActivity(new Intent(getApplicationContext(), cronometros.class));
                return true;
            }
              else if (item.getItemId() == R.id.bottom_tareas) {
                startActivity(new Intent(getApplicationContext(), tareas.class));
                return true;
            }
            else if (item.getItemId() == R.id.bottom_opciones) {
                return true;
            }

            return false;
        });
    }
}