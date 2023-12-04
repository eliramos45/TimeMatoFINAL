package com.example.timemato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class cronometros extends AppCompatActivity {
    //Estas declaraciones son usadas para el tablayout
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometros);

        tabLayout = findViewById(R.id.cronometrosLayout);
        viewPager = findViewById(R.id.viewPagerCronometros);

        ImageView userProfilePic = findViewById(R.id.userProfilePic);

        //Llevar a perfil
        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(cronometros.this, perfil.class);
                startActivity(intento);
            }
        });

        //Menu tablayout de navegacion
        tabLayout.setupWithViewPager(viewPager);
        vpAdapter vpAdapter = new vpAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new enfoque_cronometros(), "Enfoque");
        vpAdapter.addFragment(new descanso_cronometros(), "Descanso");
        vpAdapter.addFragment(new descansolargo_cronometros(), "Descanso Largo");
        viewPager.setAdapter(vpAdapter);


        //Menu inferior de navegacion
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_cronometro);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), menu_principal.class));
                return true;
            } else if (item.getItemId() == R.id.bottom_consejos) {
                startActivity(new Intent(getApplicationContext(), consejos.class));
                return true;
            } else if (item.getItemId() == R.id.bottom_cronometro) {
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