package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        String valorRecibido = null;
        Intent InicioNav = getIntent();

        if(InicioNav != null){
            valorRecibido = InicioNav.getStringExtra("username");
            TextView textViewValorRecibido = findViewById(R.id.textViewValorRecibido);
            textViewValorRecibido.setText(valorRecibido);
        };


        if (valorRecibido != null){
            Toast.makeText(InicioActivity.this, valorRecibido, Toast.LENGTH_SHORT).show();
        };
    }
}