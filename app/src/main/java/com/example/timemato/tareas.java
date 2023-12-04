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

public class tareas extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        tabLayout = findViewById(R.id.tareasLayout);
        viewPager = findViewById(R.id.viewPagerTareas);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_tareas);
        ImageView userProfilePic = findViewById(R.id.userProfilePic);

        //Llevar a perfil
        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(tareas.this, perfil.class);
                startActivity(intento);
            }
        });

        //Menu tablayout de navegacion
        tabLayout.setupWithViewPager(viewPager);
        vpAdapter2 vpAdapter2 = new vpAdapter2(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter2.addFragment(new diario_tareas(), "Diario");
        vpAdapter2.addFragment(new semanal_tareas(), "Entre semana");
        vpAdapter2.addFragment(new findesemana_tareas(), "Fin de semana");
        viewPager.setAdapter(vpAdapter2);

        //Menu de navegacion inferior
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