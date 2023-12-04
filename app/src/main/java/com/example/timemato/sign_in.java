package com.example.timemato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class sign_in extends AppCompatActivity {

    TextInputEditText editTextEmail, editextPassword;

    Button registrarseBTN;

    TextView iniciarSesionTxt;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextEmail = findViewById(R.id.email2);
        editextPassword = findViewById(R.id.password2);
        registrarseBTN = findViewById(R.id.btnRegistrarse);
        iniciarSesionTxt = findViewById(R.id.tvIniciarSesion);

        iniciarSesionTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volverAiniciarSesion = new Intent(sign_in.this, login.class);
                startActivity(volverAiniciarSesion);
                finish();
            }
        });


        registrarseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email2, password2;
                email2 = String.valueOf(editTextEmail.getText());
                password2 = String.valueOf(editextPassword.getText());

                if (TextUtils.isEmpty(email2)){
                    Toast.makeText(sign_in.this, "Ingresa tu Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password2)){
                    Toast.makeText(sign_in.this, "Ingresa tu contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email2,password2)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(sign_in.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                                    Intent intentoRegistrar = new Intent(sign_in.this, login.class); 
                                    startActivity(intentoRegistrar);

                                }
                                else{
                                    Toast.makeText(sign_in.this, "Error en el Registro", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });

    }
}