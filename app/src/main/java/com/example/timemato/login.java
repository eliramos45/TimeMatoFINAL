package com.example.timemato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    TextInputEditText editTextEmail, editextPassword;

    Button iniciarSesionBTN;

    TextView registrarseTxt;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.email);
        editextPassword = findViewById(R.id.password);
        iniciarSesionBTN = findViewById(R.id.btnIniciarSesion);
        registrarseTxt = findViewById(R.id.tvRegistrarse);

        registrarseTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarseIntent = new Intent(login.this, sign_in.class);
                startActivity(registrarseIntent);
                finish();
            }
        });

        iniciarSesionBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editextPassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(login.this, "Ingresa tu Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(login.this, "Ingresa tu contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(login.this, "Ingresaste Correctamente", Toast.LENGTH_SHORT).show();
                                    Intent intentInicioSesion =new Intent(login.this, menu_principal.class);
                                    startActivity(intentInicioSesion);

                                }
                                else {
                                    Toast.makeText(login.this, "Error al Iniciar Sesión", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }
}