package com.example.adrianch.examen_practico2;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ListaRestaurantes extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    Context context;


    ListadoRestaurantes clickedObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_restaurantes);
        lista = findViewById(R.id.listViewRestaurantesAgregados);


        lista.setOnItemClickListener(this);
        context = getApplicationContext();
        try {
            cargarDatos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarDatos() throws IOException {
        List<String> listadoNombres = new ArrayList<String>();
        List<String> listadoImagenes = new ArrayList<String>();
        List<String> listadoDireccion = new ArrayList<String>();
        List<String> listadoDescripcion = new ArrayList<String>();
        List<String> listadoValorRating = new ArrayList<>();
        String linea, linea2;

        File ruta_sd = Environment.getExternalStorageDirectory();
        File f = new File(ruta_sd.getAbsolutePath(), "Restaurantes.txt");
        File g = new File(ruta_sd.getAbsolutePath(), "Opiniones.txt");

        //InputStream is = this.getResources().openRawResource(R.raw.lista_restaurantes);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(f)));


        BufferedReader reader2 =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(g)));
        if (f != null) {
            while ((linea = reader.readLine()) != null) {
                listadoImagenes.add(linea.split(";")[0]);
                listadoNombres.add(linea.split(";")[1]);
                listadoDescripcion.add(linea.split(";")[2]);
                listadoDireccion.add(linea.split(";")[3]);


            }
        }

        if (g != null){
            while ((linea2 = reader2.readLine()) != null){
                listadoValorRating.add(linea2.split(";")[0]);
            }
        }
        reader.close();

        String listadoNombresS[] = listadoNombres.toArray(new String[listadoNombres.size()]);
        String listadoImagenesS[] = listadoImagenes.toArray(new String[listadoImagenes.size()]);
        String listadoDireccionS[] = listadoDireccion.toArray(new String[listadoDireccion.size()]);
        String listadoDescripcionS[] = listadoDescripcion.toArray(new String[listadoDescripcion.size()]);
        String listadoValorRatingS[] = listadoValorRating.toArray(new String[listadoValorRating.size()]);


        ListadoRestaurantes[] datos = new ListadoRestaurantes[listadoDescripcionS.length];
        for (int valor = 0; valor < datos.length; valor++) {
            datos[valor] = new ListadoRestaurantes(Integer.parseInt(listadoImagenesS[valor]), listadoNombresS[valor], listadoDireccionS[valor], listadoDescripcionS[valor], Float.parseFloat(listadoValorRatingS[valor]));
        }
        lista.setAdapter(new ListaRestaurantesAdapter(this, R.layout.lista_restaurante, datos));
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


         notifyDataSetChanged();
      //  ((ListaRestaurantesAdapter) lista.getAdapter()).notifyDataSetChanged();
       // lista.refreshDrawableState();
      //  lista.invalidateViews();
      //  Toast.makeText(this,"bien datos guardados",Toast.LENGTH_LONG).show();

        }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

      clickedObj = (ListadoRestaurantes) adapterView.getItemAtPosition(i);
       String nombreRes, descripRes, direcRes;
       int itemSeleccionado;
       int valorImage;

       nombreRes = clickedObj.nombreRestaurante;
       descripRes = clickedObj.descripcionRestaurante;
       direcRes = clickedObj.direccionRestaurante;
       valorImage = clickedObj.imagenRestaurante;
       itemSeleccionado  = i;

       Intent intent = new Intent(this, Evaluacion.class);
         intent.putExtra("NOMBRE", nombreRes);
        intent.putExtra("DIRECCION", direcRes);
        intent.putExtra("DESCRIPCION", descripRes);
        intent.putExtra("IMAGEN", valorImage);
        intent.putExtra("ITEM_SELECCIONADO", itemSeleccionado);

         startActivityForResult(intent, 123);


    }
    private ArrayList<DataSetObserver> observers = new ArrayList<DataSetObserver>();

    public void registerDataSetObserver(DataSetObserver observer) {
        observers.add(observer);
    }
    public void notifyDataSetChanged(){
        for (DataSetObserver observer: observers) {
            observer.onChanged();
        }
    }
}