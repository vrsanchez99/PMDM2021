package com.example.holausuario_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoNombre = null;
    private EditText campoEdad = null;

    private Button btnAceptar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoEdad = (EditText) findViewById(R.id.campoEdad);
        campoNombre = (EditText) findViewById(R.id.campoNombre);
        btnAceptar = (Button) findViewById(R.id.botonAceptar);

        campoEdad.setInputType(InputType.TYPE_CLASS_NUMBER);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("TEST BOTON");

                if (( !campoEdad.getText().toString().matches(""))
                        && ( !campoNombre.getText().toString().matches(""))) {

                    String nombre = campoNombre.getText().toString();
                    String edad = campoEdad.getText().toString();

                    String data[] = new String[]{nombre, edad};

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("user_Data", data);
                    startActivity(intent);
                } else {

                    Toast.makeText(getApplicationContext(),
                            "Ningún campo puede quedar vacío.",
                            Toast.LENGTH_LONG);

                }

            }
        });

    }


}