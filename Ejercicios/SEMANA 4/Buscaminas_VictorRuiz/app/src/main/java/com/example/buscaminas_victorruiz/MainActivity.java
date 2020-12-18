package com.example.buscaminas_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private GridLayout tablero;
    private boolean gameOver = false;
    private TextView textView;
    private int banderas = 15;
    private final int size = 8;
    private Casilla[][] tableroAuxiliar = new Casilla[size][size];


    private final char bomba = 'b';
    private final char bombaEncontrada = 'x';

    private final char flag = 'f';
    private final char hidden = '.';
    private final char clear = 'c';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se crea el tablero de tipo gridLayout, de dimensiones 8x8
        tablero = (GridLayout) findViewById(R.id.gridTablero);
        tablero.setColumnCount(size);
        tablero.setRowCount(size);
        textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);


        llenarTablero();
        colocarMinasEnTablero();
        contarBombas();


    }


    public ImageButton casilla() {

        ImageButton casilla = new ImageButton(this);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams(
                new ViewGroup.LayoutParams(
                        50,
                        50
                )

        );
        params.setMargins(15, 15, 15, 15);
        casilla.setLayoutParams(params);
        casilla.setBackgroundColor(Color.GREEN);
        // casilla.setOnTouchListener(this);
        casilla.setOnClickListener(this);
        casilla.setOnLongClickListener(this);

        return casilla;
    }


    public void llenarTablero() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ImageButton casilla = casilla();
                casilla.setTag(i + "" + j);
                tablero.addView(casilla);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tableroAuxiliar[i][j] = new Casilla();
            }
        }

    }

    /**
     *
     */
    public void colocarMinasEnTablero() {

        int minas = 10;
        do {
            int fila = (int) (Math.random() * 8);
            int columna = (int) (Math.random() * 8);

            if (this.tableroAuxiliar[fila][columna].getContenido() == hidden) {
                this.tableroAuxiliar[fila][columna].setContenido(bomba);
                minas--;
            }
        } while (minas > 0);


    }


    /**
     * @param v
     */
    public boolean colocarBandera(View v) {


        if (v instanceof ImageButton) {

            ImageButton aux = (ImageButton) v;

            aux.setBackgroundResource(R.drawable.ic_baseline_flag_24);


        }
        return false;
    }


    public void game() {


        if (!gameOver) {


        }

    }


    /**
     * @param f
     * @param c
     * @throws InterruptedException
     */
    public void floodFill(int f, int c, View v) {
        String tag = f + "" + c;
        View v2 = v.getRootView().findViewWithTag(tag);
        ImageButton aux = (ImageButton) v2;
        if (f >= 0 && f < 8 && c >= 0 && c < 8) {
            if (tableroAuxiliar[f][c].getContenido() == hidden) {

                tableroAuxiliar[f][c].setDestapado(true);
                tableroAuxiliar[f][c].setContenido(clear);
                aux.setBackgroundColor(Color.BLUE);
                floodFill(f, c + 1, v);
                floodFill(f, c - 1, v);
                floodFill(f + 1, c, v);
                floodFill(f - 1, c, v);
                floodFill(f - 1, c - 1, v);
                floodFill(f - 1, c + 1, v);
                floodFill(f + 1, c + 1, v);
                floodFill(f + 1, c - 1, v);
            } else if (Character.getNumericValue(tableroAuxiliar[f][c].getContenido()) >= 1
                    && Character.getNumericValue(tableroAuxiliar[f][c].getContenido()) <= 8) {
                char num = tableroAuxiliar[f][c].getContenido();

                switch (num) {

                    case '1':
                        aux.setBackgroundResource(R.drawable.ic_baseline_filter_1_24);
                        break;
                    case '2':
                        aux.setBackgroundResource(R.drawable.ic_baseline_filter_2_24);
                        break;
                    case '3':
                        aux.setBackgroundResource(R.drawable.ic_baseline_filter_3_24);
                        break;
                    case '4':
                        aux.setBackgroundResource(R.drawable.ic_baseline_filter_4_24);
                        break;
                    case '5':
                        aux.setBackgroundResource(R.drawable.ic_baseline_filter_5_24);
                        break;
                    case '6':
                        aux.setBackgroundResource(R.drawable.ic_baseline_filter_6_24);
                        break;
                    case '7':
                        aux.setBackgroundResource(R.drawable.ic_baseline_filter_7_24);
                        break;
                    case '8':
                        aux.setBackgroundResource(R.drawable.ic_baseline_filter_8_24);
                        break;
                    default:
                }
                tableroAuxiliar[f][c].setDestapado(true);
            }
        }


    }


    public void contarBombas() {


        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                if (tableroAuxiliar[f][c].getContenido() == hidden) {
                    int cant = contarCoordenada(f, c);
                    if (cant != 0) {
                        String aux = String.valueOf(cant);
                        char a = aux.charAt(0);
                        tableroAuxiliar[f][c].setContenido(a);
                    }
                }
            }
        }


    }

    /**
     * @param fila
     * @param columna
     * @return
     */
    public int contarCoordenada(int fila, int columna) {
        int total = 0;
        if (fila - 1 >= 0 && columna - 1 >= 0) {
            if (tableroAuxiliar[fila - 1][columna - 1].getContenido() == bomba)
                total++;
        }
        if (fila - 1 >= 0) {
            if (tableroAuxiliar[fila - 1][columna].getContenido() == bomba)
                total++;
        }
        if (fila - 1 >= 0 && columna + 1 < 8) {
            if (tableroAuxiliar[fila - 1][columna + 1].getContenido() == bomba)
                total++;
        }

        if (columna + 1 < 8) {
            if (tableroAuxiliar[fila][columna + 1].getContenido() == bomba)
                total++;
        }
        if (fila + 1 < 8 && columna + 1 < 8) {
            if (tableroAuxiliar[fila + 1][columna + 1].getContenido() == bomba)
                total++;
        }

        if (fila + 1 < 8) {
            if (tableroAuxiliar[fila + 1][columna].getContenido() == bomba)
                total++;
        }
        if (fila + 1 < 8 && columna - 1 >= 0) {
            if (tableroAuxiliar[fila + 1][columna - 1].getContenido() == bomba)
                total++;
        }
        if (columna - 1 >= 0) {
            if (tableroAuxiliar[fila][columna - 1].getContenido() == bomba)
                total++;
        }
        return total;
    }


    /// EVENT METHODS

    @Override
    public void onClick(View v) {

        if (v instanceof ImageButton) {

            ImageButton aux = (ImageButton) v;


            String a = aux.getTag().toString();

            int fila = Character.getNumericValue(a.charAt(0));
            int col = Character.getNumericValue(a.charAt(1));

            if (tableroAuxiliar[fila][col].getContenido() == bomba) {
                perder();
                textView.setVisibility(View.VISIBLE);
            } else if (true) {

                floodFill(fila, col, v);

            }

        }


    }

    public void perder() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tableroAuxiliar[i][j].setDestapado(true);
                if (tableroAuxiliar[i][j].getContenido() == bomba) {

                    tablero.getChildAt((i * 8) + j).setBackgroundResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);

                }
            }
        }

        for (int i = 0; i < tablero.getChildCount(); i++) {

            View v = tablero.getChildAt(i);

            if (v instanceof ImageButton) {

                ImageButton aux = (ImageButton) v;
                v.setEnabled(false);

            }


        }


    }

    @Override
    public boolean onLongClick(View v) {
        return colocarBandera(v);
    }


}


