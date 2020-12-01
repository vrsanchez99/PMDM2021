package com.example.listview_dinamico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private ListView listadoAgenda;
    private EditText campoAgregar;

    ArrayAdapter<String> arrayadapter;

    String[] ListElements = new String[]{
            "pepe : 1234567",
            "paco : 987654",
            "pepa : 876234567",
    };

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAgregar);
        listadoAgenda = (ListView) findViewById(R.id.lista);
        campoAgregar = (EditText) findViewById(R.id.campoAgregar);

        final List<String> listArrayList = new ArrayList<>(Arrays.asList(ListElements));

        arrayadapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listArrayList);

        listadoAgenda.setAdapter(arrayadapter);

        listadoAgenda.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                // TODO Auto-generated method stub

                final AlertDialog show = new AlertDialog.Builder(context)
                        .setTitle("titulo")
                        .setMessage("Borrar elemento?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {

                                listArrayList.remove(position);

                                arrayadapter.notifyDataSetChanged();

                                Toast.makeText(MainActivity.this, "Elemento borrado", Toast.LENGTH_LONG).show();

                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();


                return true;
            }

        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (campoAgregar.getText() != null || !campoAgregar.getText().equals("")) {

                    listArrayList.add(campoAgregar.getText().toString());
                    arrayadapter.notifyDataSetChanged();

                } else {

                    Toast.makeText(MainActivity.this, "El campo no puede quedar vacío.", Toast.LENGTH_LONG).show();


                }
            }
        });

    }


}