package com.example.adrianch.examen_practico2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Button btncapturar,btnmostrar,btnsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btncapturar =  findViewById(R.id.btncapturar);
        btnmostrar =  findViewById(R.id.btnmostrar);
        btnsalir = findViewById(R.id.btnsalir);

    }
public void onClickCapturar (View v){
    Intent intent=new Intent(Principal.this,datos.class);
    startActivity(intent);

    }
    public void onClickSalir (View v){
    finish();

    }

    public void onClickMostrar (View v){
        Intent intent = new Intent(this, ListaRestaurantes.class);
        startActivity(intent);
    }
}
