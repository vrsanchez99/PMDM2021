package com.example.vrs_hundirlaflota;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GridLayout tableroEnemigo;
    private GridLayout tableroJugador;

    private MediaPlayer mediaPlayer;
    private char fallo = 'A';
    private char acierto = 'X';

    private int posicionColumna =0, posicionFila=0;

    private TextView ptosBot, ptosJug;
    private Button btnCol, btnFila;

    private int puntosBot = 14, puntosJugador=14;
    private String[] columnas= new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    private String[]  filas = new String[]{"1", "2", "3", "4", "5" ,"6" , "7", "8"};
    private boolean fin=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();

        btnCol = (Button) findViewById(R.id.btnColumna);
        btnFila = (Button) findViewById(R.id.btnFila);

        btnCol.setOnClickListener(this);
        btnFila.setOnClickListener(this);

        tableroEnemigo = new GridLayout(this);
        tableroJugador = new GridLayout(this);

        tableroEnemigo = (GridLayout) findViewById(R.id.tableroEnemigo);
        tableroJugador = (GridLayout) findViewById(R.id.tableroJugador);


        ptosBot = (TextView)findViewById(R.id.txtPuntosBot);
        ptosJug = (TextView)findViewById(R.id.txtPuntosJug);
        ptosJug.setText(""+puntosJugador);
        ptosBot.setText(""+puntosBot);


        //Se rellenan ambos tableros con puntos, y luego de forma aleatoria
        //se colocan los barcos de cada uno.
        llenarTablero(tableroEnemigo);
        llenarTablero(tableroJugador);

    }


    /**
     *
     * @param gridLayout
     */
    public void llenarTablero(GridLayout gridLayout) {

        gridLayout.setColumnCount(8);
        gridLayout.setRowCount(8);

        for (int i = 0; i < gridLayout.getRowCount(); i++) {

            for (int j = 0; j < gridLayout.getColumnCount(); j++) {

                gridLayout.addView(casilla());

            }


        }


    }


    /**
     *
     * @return
     */
    public TextView casilla() {

        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(
                50,
                50));

        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.result_font));
        textView.setText(".");
        textView.setTextColor(Color.BLACK);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        return textView;
    }

    /**
     * Se colocan barcos de 1, 3 y 5 casillas de forma aleatoria.
     * Habrán 3 barcos de 1 posicion, 2 barcos de 3 posiciones y 1 barco de 5 posiciones
     * para cada tablero, respectivamente.
     * @param tablero
     */
    public void colocarBarcos(GridLayout tablero){




        for (int i = 0; i < tablero.getChildCount(); i=+8) {
            View child = tablero.getChildAt(i);
            if (child instanceof TextView) {
                ((TextView) child).setText("G");
            }

        }





    }

    public void movimientoBot(){

        int posicion = (int) (Math.random() * (63 - 1 + 1) + 1);




    }


    public int seleccionColumna(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona la columna del tablero enemigo");
        builder.setItems(columnas, (dialog, pos) -> {
            switch (columnas[pos]){

                case "A":
                    posicionColumna = 0;
                    break;
                case "B":
                    posicionColumna = 8;
                    break;
                case "C":
                    posicionColumna = 16;
                    break;
                case "D":
                    posicionColumna = 24;
                    break;
                case "E":
                    posicionColumna = 32;
                    break;
                case "F":
                    posicionColumna = 40;
                    break;
                case "G":
                    posicionColumna =  48;
                    break;
                case "H":
                    posicionColumna = 56;
                    break;
                default:


            }
        }).show();

        return posicionColumna;
    }

    public int seleccionFila(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona la fila del tablero enemigo");
        builder.setItems(filas, (dialog, pos) -> {
            switch (filas[pos]){

                case "1":
                    posicionFila = 0;
                    break;
                case "2":
                    posicionFila = 1;
                    break;
                case "3":
                    posicionFila = 2;
                    break;
                case "4":
                    posicionFila = 3;
                    break;
                case "5":
                    posicionFila = 4;
                    break;
                case "6":
                    posicionFila = 5;
                    break;
                case "7":
                    posicionFila = 6;
                    break;
                case "8":
                    posicionFila = 7;
                    break;
                default:


            }
        }).show();


        return posicionFila;
    }

    //////////////////////7

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnColumna:
                seleccionColumna();
                break;

            case R.id.btnFila:
                seleccionFila();
                break;


        }

    }
}