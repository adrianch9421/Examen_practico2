package com.example.adrianch.examen_practico2;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Evaluacion extends AppCompatActivity {
    TextView txtVwNombre, txtVwDescripcion, txtVwDireccion;
    ImageView imgViewRestaurant;
    RatingBar ratingBar;
    Button btnGuardarOpinion;
    int itemSeleciconado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        txtVwNombre = findViewById(R.id.EvaNombreRestaurante);
        txtVwDescripcion = findViewById(R.id.evaDescripcionRestaurante);
        txtVwDireccion = findViewById(R.id.EvaDireccionRestaurate);
        imgViewRestaurant = findViewById(R.id.evaImgVw);
        ratingBar = findViewById(R.id.ratingBar);
        btnGuardarOpinion = findViewById(R.id.buttonGuardarOpinion);

        txtVwNombre.setText(b.getString("NOMBRE"));
        txtVwDescripcion.setText(b.getString("DESCRIPCION"));
        txtVwDireccion.setText(b.getString("DIRECCION"));
        imgViewRestaurant.setImageResource(b.getInt("IMAGEN"));
        itemSeleciconado = b.getInt("ITEM_SELECCIONADO");

    }

    public void onClickGuardarOpinion(View view) throws IOException {
       String linea2;
        List<String> listadoValorRating = new ArrayList<>();


        Intent i = getIntent();
        String valor = String.valueOf(ratingBar.getRating());

        File ruta_sd = Environment.getExternalStorageDirectory();
        File g = new File(ruta_sd.getAbsolutePath(), "Opiniones.txt");

        BufferedReader reader2 =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(g)));

        if (g != null){
            while ((linea2 = reader2.readLine()) != null){
                listadoValorRating.add(linea2.split(";")[0]);
            }
        }

        OutputStreamWriter fout2 =
                new OutputStreamWriter(
                        new FileOutputStream(g,false));

        String listadoValorRatingS[] = listadoValorRating.toArray(new String[listadoValorRating.size()]);
       // Toast.makeText(this, ""+ listadoValorRating.get(itemSeleciconado),Toast.LENGTH_SHORT).show();
       listadoValorRatingS[itemSeleciconado] = valor;

        for (int valorArray = 0; valorArray < listadoValorRatingS.length; valorArray++ ){
            fout2.append(listadoValorRatingS[valorArray]+"\n");
        }
        fout2.close();

        setResult(RESULT_OK, i);

        
        Intent intent=new Intent(Evaluacion.this,Principal.class);
        Toast.makeText(getApplicationContext(), "Gracias por su valoración",Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();


    }


}
