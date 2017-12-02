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
import android.widget.TextView;

/**
 * Created by Adrian Ch on 22/11/2017.
 */

public class ImagenesRestaurantesAdapter extends ArrayAdapter<ImagenesRestaurantes> implements ListAdapter {
    Context contexto;
    int iLayout;
    ImagenesRestaurantes[] imagenesRestaurantes;

    public ImagenesRestaurantesAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ImagenesRestaurantes[] objects) {
        super(context, resource, objects);
        contexto = context;
        iLayout = resource;
        imagenesRestaurantes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVwDet;
        TextView txtVwRestDet, txtVwDescDet;
        View vwFila = convertView;

        if (vwFila == null) { //La lista se llena por primera vez
            LayoutInflater CrearLayout = ((Activity) contexto).getLayoutInflater();
            vwFila = CrearLayout.inflate(iLayout, parent, false);
        }

        imgVwDet = (ImageView) vwFila.findViewById(R.id.imgVw);

        //Llenar datos
        imgVwDet.setImageResource(imagenesRestaurantes[position].imagenRestaurante);
        //  txtVwDescDet.setText(imagenesRestaurantes[position].);
        return vwFila;
        //return super.getView(position, convertView, parent);
    }
}


