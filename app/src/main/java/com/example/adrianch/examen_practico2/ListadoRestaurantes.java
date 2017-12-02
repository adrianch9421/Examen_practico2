package com.example.adrianch.examen_practico2;

/**
 * Created by Adrian Ch on 26/11/2017.
 */

class ListadoRestaurantes {
    int imagenRestaurante;
    String nombreRestaurante, direccionRestaurante, descripcionRestaurante;
    Float valorRating;

    public ListadoRestaurantes() {
        imagenRestaurante = R.drawable.barrafina;
        nombreRestaurante = "";
        direccionRestaurante = "";
        descripcionRestaurante = "";
        valorRating = Float.valueOf(0);
    }

    public ListadoRestaurantes(int imgRestaurante, String nameRestaurant, String direccRestauran, String descripResta, Float valor){
        imagenRestaurante = imgRestaurante;
        nombreRestaurante = nameRestaurant;
        direccionRestaurante = direccRestauran;
        descripcionRestaurante = descripResta;
        valorRating = valor;
    }

}
