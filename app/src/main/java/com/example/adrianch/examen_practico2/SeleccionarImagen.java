package com.example.adrianch.examen_practico2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SeleccionarImagen extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lstVwLista;
    Context contexto;

    ImagenesRestaurantes[] arregloRestaurantes = {
            new ImagenesRestaurantes(R.drawable.bourkestreetbakery),
            new ImagenesRestaurantes(R.drawable.cafedeadend),
            new ImagenesRestaurantes(R.drawable.cafeloisl),
            new ImagenesRestaurantes(R.drawable.cafelore),
            new ImagenesRestaurantes(R.drawable.confessional),
            new ImagenesRestaurantes(R.drawable.donostia),
            new ImagenesRestaurantes(R.drawable.fiveleaves),
            new ImagenesRestaurantes(R.drawable.forkeerestaurant),
            new ImagenesRestaurantes(R.drawable.grahamavenuemeats),
            new ImagenesRestaurantes(R.drawable.haighschocolate),
            new ImagenesRestaurantes(R.drawable.homei),
            new ImagenesRestaurantes(R.drawable.palominoespresso),
            new ImagenesRestaurantes(R.drawable.petiteoyster),
            new ImagenesRestaurantes(R.drawable.posatelier),
            new ImagenesRestaurantes(R.drawable.royaloak),
            new ImagenesRestaurantes(R.drawable.teakha),
            new ImagenesRestaurantes(R.drawable.thaicafe)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_imagen);

        lstVwLista = (ListView) findViewById(R.id.lstVwLista);
        lstVwLista.setAdapter(new ImagenesRestaurantesAdapter(this, R.layout.seleccionar_imagen, arregloRestaurantes));
        lstVwLista.setOnItemClickListener(this);
        contexto = getApplicationContext();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       // Toast.makeText(this, "" + arregloRestaurantes[position].imagenRestaurante, Toast.LENGTH_SHORT).show();
        Intent i = getIntent();
        i.putExtra("ImagenSeleccionada", String.valueOf(arregloRestaurantes[position].imagenRestaurante));
        setResult(RESULT_OK, i);
        finish();

    }

}
