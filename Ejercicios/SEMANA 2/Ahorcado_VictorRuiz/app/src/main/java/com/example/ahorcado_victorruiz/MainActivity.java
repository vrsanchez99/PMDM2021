package com.example.ahorcado_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] palabras;
    int intentos = 4;
    boolean fin = false;
    ImageView head, body, leftArm, rightArm;
    Button btn;
    EditText letra;
    String palabra;
    TextView palabraAResolver;
    char[] splitWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        head = (ImageView) findViewById(R.id.head);
        body = (ImageView) findViewById(R.id.body);
        leftArm = (ImageView) findViewById(R.id.leftArm);
        rightArm = (ImageView) findViewById(R.id.rightArm);
        letra = (EditText) findViewById(R.id.letra);
        btn = (Button) findViewById(R.id.button);
        palabraAResolver = (TextView) findViewById(R.id.textView2);

        head.setVisibility(View.INVISIBLE);
        //head.setImageAlpha(10);
        body.setVisibility(View.INVISIBLE);
        leftArm.setVisibility(View.INVISIBLE);
        rightArm.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(this);

        palabras = new String[]{"peluche", "cabra", "muerte", "blair"};

        palabra = palabraAleatoria();


        for (int i = 0; i < palabra.length(); i++) {

            palabraAResolver.setText(palabraAResolver.getText().toString() + "-");

        }


        splitWord = palabra.toCharArray();


    }

    public void mostrarParteAhorcado() {

        if (intentos == 3) {
            head.setVisibility(View.VISIBLE);
        } else if (intentos == 2) {
            body.setVisibility(View.VISIBLE);
        } else if (intentos == 1) {
            leftArm.setVisibility(View.VISIBLE);
        } else if (intentos == 0) {
            rightArm.setVisibility(View.VISIBLE);
        }


    }


    /**
     * @param palabra
     * @param letra
     * @return
     */
    public boolean contieneLetra(String palabra, String letra) {

        if (palabra.contains(letra)) return true;
        else return false;

    }

    public void partida() {

        if (intentos > 0 || !fin) {

System.out.println("- "+letra.getText()+" -");
            if (!letra.getText().toString().equals(null) ||
                    !letra.getText().toString().equals("")) {

                System.out.println("TEST");
                if (contieneLetra(palabra, letra.getText().toString())) {
                    for (int i = 0; i < splitWord.length; i++) {

                        if (splitWord[i] == letra.getText().toString().charAt(0)) {
                            palabraAResolver.setText(palabraAResolver.getText().toString().substring(i).replace('-', letra.getText().charAt(0)));
                        }
                    }

                } else {

                    Toast.makeText(getApplicationContext(),
                            "La palabra no contiene  esa letra",
                            Toast.LENGTH_LONG)
                            .show();
                    mostrarParteAhorcado();
                    intentos--;
                }


            } else {

                Toast.makeText(getApplicationContext(),
                        "Introduce una letra!",
                        Toast.LENGTH_LONG)
                        .show();
            }
        } else {

            if (intentos == 0) {
                Toast.makeText(getApplicationContext(),
                        "Perdiste",
                        Toast.LENGTH_LONG)
                        .show();
                letra.setEnabled(false);
            } else if (palabraResuelta()) {
                fin = true;
                Toast.makeText(getApplicationContext(),
                        "Ganaste",
                        Toast.LENGTH_LONG)
                        .show();
                letra.setEnabled(false);

            }


        }
    }

    public boolean palabraResuelta() {
        return palabraAResolver.getText().toString().contains("-");
    }


    public String palabraAleatoria() {
        return palabras[new Random().nextInt(palabras.length)];
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button) {

            partida();

        }

    }
}