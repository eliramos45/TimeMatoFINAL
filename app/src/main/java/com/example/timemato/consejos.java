package com.example.timemato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class consejos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_consejos);

        ImageView userProfilePic = findViewById(R.id.userProfilePic);

        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(consejos.this, perfil.class);
                startActivity(intento);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), menu_principal.class));
                return true;
            } else if (item.getItemId() == R.id.bottom_consejos) {
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
                startActivity(new Intent(getApplicationContext(), opciones.class));
                return true;
            }

            return false;
        });
    }
}