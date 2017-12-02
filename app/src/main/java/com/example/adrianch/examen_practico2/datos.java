package com.example.adrianch.examen_practico2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class datos extends AppCompatActivity {


    ImageButton imageButton;
    EditText editTextNombre, editTextDescripcion, editTextDireccion;
    String nombreRestaurant, descripcionRestaurant, direccionRestaurant, resultado;
    int imaRestaurant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageButton = findViewById(R.id.imageButton);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextDescripcion = findViewById(R.id.editTextDescripcion);
        editTextDireccion = findViewById(R.id.editTextDireccion);

    }

    public void onClickSeleccionarImagen(View v) {
        Intent intent = new Intent(datos.this, SeleccionarImagen.class);
        startActivityForResult(intent, 1000);
    }

    public void onClickGuardarRestaurante(View v) throws IOException {
        nombreRestaurant = editTextNombre.getText().toString();
        descripcionRestaurant = editTextDescripcion.getText().toString();
        direccionRestaurant = editTextDireccion.getText().toString();
        imaRestaurant = Integer.parseInt(resultado);

    boolean sdDisponible = false;
    boolean sdAccesoEscritura = false;

    String estado = Environment.getExternalStorageState();

    if (estado.equals(Environment.MEDIA_MOUNTED)){
        sdDisponible = true;
        sdAccesoEscritura = true;
    }

    try{
        File ruta_sd = Environment.getExternalStorageDirectory();
        File f = new File(ruta_sd.getAbsolutePath(), "Restaurantes.txt" );
        File g = new File(ruta_sd.getAbsolutePath(), "Opiniones.txt");

        OutputStreamWriter fout =
                new OutputStreamWriter(
                        new FileOutputStream(f,true));

        OutputStreamWriter fout2 =
                new OutputStreamWriter(
                        new FileOutputStream(g,true));

        fout.append(imaRestaurant+";"+nombreRestaurant+";"+descripcionRestaurant+";"+direccionRestaurant+ ";"+"\n");
        fout.close();

        fout2.append("3;\n");
        fout2.close();

    } catch (Exception ex){
        Log.e("Ficheros", "error msg");
    }




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            resultado = data.getExtras().getString("ImagenSeleccionada");
            imageButton.setImageResource(Integer.parseInt(resultado));
        }
    }

}
