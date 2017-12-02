package com.example.adrianch.examen_practico2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Adrian Ch on 26/11/2017.
 */

class ListaRestaurantesAdapter extends ArrayAdapter<ListadoRestaurantes> implements ListAdapter {
    Context contexto;
    int iLayout;
    ListadoRestaurantes[] listadoRestaurantes;
    RatingBar ratingBar;



    public ListaRestaurantesAdapter(@NonNull Context context, @LayoutRes int resource,@NonNull ListadoRestaurantes[] objects) {
        super(context, resource, objects );
        contexto = context;
        iLayout = resource;
        listadoRestaurantes = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVwDet;
        TextView txtViewNombreRestaurant, txtVwDescrip, txtVwDireec;
        View vwFila = convertView;

        if(vwFila == null){
            LayoutInflater CrearLayout = ((Activity) contexto).getLayoutInflater();
            vwFila = CrearLayout.inflate(iLayout, parent, false);
        }

        imgVwDet = vwFila.findViewById(R.id.imageViewRestaurante);
        txtViewNombreRestaurant = vwFila.findViewById(R.id.textViewNombreRestaurante);
        txtVwDescrip = vwFila.findViewById(R.id.textViewDescripcionRestaurante);
        txtVwDireec = vwFila.findViewById(R.id.textViewDireccionRestaurant);
        ratingBar = vwFila.findViewById(R.id.ratingBar1);

        imgVwDet.setImageResource(listadoRestaurantes[position].imagenRestaurante);
        txtViewNombreRestaurant.setText(listadoRestaurantes[position].nombreRestaurante);
        txtVwDescrip.setText(listadoRestaurantes[position].descripcionRestaurante);
        txtVwDireec.setText(listadoRestaurantes[position].direccionRestaurante);

       // listadoRestaurantes[position].valorRating = Float.parseFloat("2");
        ratingBar.setRating(listadoRestaurantes[position].valorRating);



        return vwFila;
    }

    public void ActualizarDatos(){
        notifyDataSetChanged();
    }
}
