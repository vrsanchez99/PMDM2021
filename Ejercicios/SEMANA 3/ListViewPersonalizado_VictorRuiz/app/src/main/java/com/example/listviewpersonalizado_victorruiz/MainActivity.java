package com.example.listviewpersonalizado_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listado;
    List<Persona> personas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = (ListView)findViewById(R.id.lista_personas);
        personas= new ArrayList<Persona>();

        personas.add(new Persona("PACO", 'h'));
        personas.add(new Persona("CHARO", 'm'));
        personas.add(new Persona("RICARDO", 'h'));
        personas.add(new Persona("ALBERTO", 'h'));
        personas.add(new Persona("DANI", 'h'));

        PersonaAdapter adaptadorPersonas=
                new PersonaAdapter(this, R.layout.persona_item, personas);

        listado.setAdapter(adaptadorPersonas);

    }
}