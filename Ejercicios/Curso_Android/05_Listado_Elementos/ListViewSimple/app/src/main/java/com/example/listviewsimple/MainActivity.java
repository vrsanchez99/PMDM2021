package com.example.listviewsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<String>();
        listView = (ListView) findViewById(R.id.list_item);

        lista.add("Taller Juan e Hijos");
        lista.add("Chapa y Pintura González");
        lista.add("Norauto");
        lista.add("Midas");

        ArrayAdapter<String> adaptadorTalleres = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                lista
        );


        listView.setAdapter(adaptadorTalleres);

        // Evento click sobre cada elemento de la lista
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this, "Taller seleccionado: "+lista.get(position), Toast.LENGTH_SHORT).show();
    }
}