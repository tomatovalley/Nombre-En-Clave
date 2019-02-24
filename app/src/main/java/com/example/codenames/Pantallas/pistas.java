package com.example.codenames.Pantallas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.codenames.R;

import java.util.ArrayList;


public class pistas extends AppCompatActivity {


      ListView pistaotros;
      ListView pistacolores;
      ListView pistaAcciones;
      ListView pistaSabores;
      ListView pistatamaños;
      ListView pistaclimas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pistas);

        pistaotros =  findViewById(R.id.ls_otros);

        ArrayList<String> pistaotros2 = new ArrayList();
        pistaotros2.add("Animal");
        pistaotros2.add("Mueble");
        pistaotros2.add("Cocina");
        pistaotros2.add("Electronica");
        pistaotros2.add("profesión");
        pistaotros2.add("Oficio");
        pistaotros2.add("Lugar");
        pistaotros2.add("Fruta");
        pistaotros2.add("Tecnología");
        pistaotros2.add("Salud");
        pistaotros2.add("Literatura");
        pistaotros2.add("Justicia");
        pistaotros2.add("Naturaleza");
        pistaotros2.add("Ciencia");
        pistaotros2.add("Música");
        pistaotros2.add("Oficina");
        pistaotros2.add("Baile");
        pistaotros2.add("Arte");
        pistaotros2.add("Deporte");


        ArrayAdapter adapadorotros = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pistaotros2);
        pistaotros.setAdapter(adapadorotros);

        pistacolores = findViewById(R.id.ls_colores);

        ArrayList<String> pistacolores2 = new ArrayList();
        pistacolores2.add("Negro");
        pistacolores2.add("Azul");
        pistacolores2.add("Amarillo");
        pistacolores2.add("Rojo");
        pistacolores2.add("Violeta");
        pistacolores2.add("Naranja");
        pistacolores2.add("Gris");
        pistacolores2.add("Rosa");
        pistacolores2.add("Verde");


        ArrayAdapter adapadorcolores = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pistacolores2);
        pistaotros.setAdapter(adapadorcolores);



        pistaAcciones = findViewById(R.id.ls_acciones);

        ArrayList<String> pistaacciones2 = new ArrayList();
        pistaacciones2.add("Correr");
        pistaacciones2.add("Caminar");
        pistaacciones2.add("Saltar");
        pistaacciones2.add("Cantar");
        pistaacciones2.add("Nadar");
        pistaacciones2.add("Aruñar");
        pistaacciones2.add("Volar");
        pistaacciones2.add("Trepar");
        pistaacciones2.add("Arrastrar");
        pistaacciones2.add("Bailar");
        pistaacciones2.add("Comer");
        pistaacciones2.add("Sentar");
        pistaacciones2.add("Descansar");
        pistaacciones2.add("Guardar");
        pistaacciones2.add("Ver");
        pistaacciones2.add("Cocinar");
        pistaacciones2.add("Calentar");
        pistaacciones2.add("Enfriar");
        pistaacciones2.add("Entretener");
        pistaacciones2.add("Escuchar");
        pistaacciones2.add("Trabajar");
        pistaacciones2.add("Hablar");
        pistaacciones2.add("Investigar");
        pistaacciones2.add("Construir");
        pistaacciones2.add("Viajar");


        ArrayAdapter adapadoracciones = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pistaacciones2);
        pistaotros.setAdapter(adapadoracciones);


        pistaSabores = findViewById(R.id.ls_sabores);

        ArrayList<String> pistasabores2 = new ArrayList();
        pistasabores2.add("Dulce");
        pistasabores2.add("Salado");
        pistasabores2.add("Ácido");
        pistasabores2.add("Amargo");
        pistasabores2.add("Refrescante");
        pistasabores2.add("Picante");
        pistasabores2.add("Agrio");



        ArrayAdapter adapadorsabores = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pistasabores2);
        pistaotros.setAdapter(adapadorsabores);

        pistatamaños = findViewById(R.id.ls_tamaños);

        ArrayList<String> pistatamaños2 = new ArrayList();
        pistatamaños2.add("Alto");
        pistatamaños2.add("Chaparro");
        pistatamaños2.add("Ancho");
        pistatamaños2.add("Delgado");
        pistatamaños2.add("Chico");




        ArrayAdapter adapadortamaños = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pistatamaños2);
        pistaotros.setAdapter(adapadortamaños);

        pistaclimas = findViewById(R.id.ls_climas);

        ArrayList<String> pistaclimas2 = new ArrayList();
        pistaotros2.add("Tropical");
        pistaotros2.add("Polares");
        pistaotros2.add("Templado");
        pistaotros2.add("Subtropical");
        pistaotros2.add("Húmedo");
        pistaotros2.add("Desierto");



        ArrayAdapter adapadorclimas = new ArrayAdapter(this, android.R.layout.simple_list_item_1,pistaclimas2);
        pistaotros.setAdapter(adapadorclimas);



    }



}
