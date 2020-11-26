package com.example.vrs_hundirlaflota;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GridLayout tableroEnemigo;
    private GridLayout tableroJugador;

    private char[][] tableroEnemigo2;
    private char[][] tableroJugador2;

    private MediaPlayer mediaPlayer, sonidoError, sonidoAcierto;
    private AudioManager audioManager;



    private char fallo = 'A';
    private char acierto = 'X';
    private static char blank = '.';

    private int posicionColumna = 0, posicionFila = 0;
    private static final int BOARD_SIZE = 8;


    private TextView ptosBot, ptosJug;
    private Button btnCol, btnFila;

    private int puntosBot = 14, puntosJugador = 14;
    private String[] columnas = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    private String[] filas = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private boolean fin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        }

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float percenth = 0.5f;
        int half = (int) (maxVolume * percenth);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, half, 0);

        sonidoAcierto = MediaPlayer.create(this, R.raw.acierto);
        sonidoError = MediaPlayer.create(this, R.raw.fallo);


        btnCol = (Button) findViewById(R.id.btnColumna);
        btnFila = (Button) findViewById(R.id.btnFila);

        btnCol.setOnClickListener(this);
        btnFila.setOnClickListener(this);

        tableroEnemigo2 = new char[BOARD_SIZE][BOARD_SIZE];
        tableroJugador2 = new char[BOARD_SIZE][BOARD_SIZE];

        tableroEnemigo = new GridLayout(this);
        tableroJugador = new GridLayout(this);

        tableroEnemigo = (GridLayout) findViewById(R.id.tableroEnemigo);
        tableroJugador = (GridLayout) findViewById(R.id.tableroJugador);


        ptosBot = (TextView) findViewById(R.id.txtPuntosBot);
        ptosJug = (TextView) findViewById(R.id.txtPuntosJug);
        ptosJug.setText("" + puntosJugador);
        ptosBot.setText("" + puntosBot);


        //Se rellenan ambos tableros con puntos, y luego de forma aleatoria
        //se colocan los barcos de cada uno.

        colocarBarcos(tableroEnemigo2);
        colocarBarcos(tableroJugador2);

        llenarTablero(tableroEnemigo, tableroEnemigo2);
        llenarTablero(tableroJugador, tableroJugador2);

    }


    /**
     * @param gridLayout
     */
    public void llenarTablero(GridLayout gridLayout, char[][] tablero) {

        gridLayout.setColumnCount(8);
        gridLayout.setRowCount(8);

        for (int i = 0; i < BOARD_SIZE; i++) {

            for (int j = 0; j < BOARD_SIZE; j++) {

                TextView textView = casilla();
                textView.setText(Character.toString(tablero[i][j]));
                gridLayout.addView(textView);

            }


        }


    }


    /**
     * @return
     */
    public TextView casilla() {

        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(
                50,
                50));
        textView.setPadding(5, 5, 5, 5);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.result_font));
        textView.setTextColor(Color.BLACK);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        return textView;
    }

    private static int aleatorio() {

        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(BOARD_SIZE);
    }

    /**
     * Se colocan barcos de 1, 3 y 5 casillas de forma aleatoria.
     * * Habrán 3 barcos de 1 posicion, 2 barcos de 3 posiciones y 1 barco de 5 posiciones
     * * para cada tablero, respectivamente.
     *
     * @param mapa
     */
    public static void colocarBarcos(char[][] mapa) {


        for (int i = 0; i < BOARD_SIZE; i++)

            for (int j = 0; j < BOARD_SIZE; j++)

                mapa[i][j] = blank;

//
        int[] barcos = {5, 5, 3, 3, 3, 1, 1, 1, 1, 1};
        char[] direccion = {'V', 'H'};

        for (int b : barcos) {

            boolean colocado = false;

            while (!colocado) {

                int fila = aleatorio();
                int columna = aleatorio();
                char direcc = direccion[aleatorio() % 2];

                if (direcc == 'V') {

                    if (fila + b <= (BOARD_SIZE - 1)) {

                        boolean otro = false;

                        for (int i = fila; (i <= fila + b) && !otro; i++) {

                            if (mapa[i][columna] != blank)

                                otro = true;
                        }

                        if (!otro) {

                            for (int i = fila; i < fila + b; i++) {

                                mapa[i][columna] = Integer.toString(b).charAt(0);
                            }

                            colocado = true;
                        }
                    }

                } else {

                    if (columna + b <= (BOARD_SIZE - 1)) {

                        boolean otro = false;

                        for (int j = columna; (j <= columna + b) && !otro; j++) {

                            if (mapa[fila][j] != blank)

                                otro = true;
                        }

                        if (!otro) {

                            for (int j = columna; j < columna + b; j++) {

                                mapa[fila][j] = Integer.toString(b).charAt(0);
                            }

                            colocado = true;
                        }
                    }
                }
            }
        }


        /////////////


    }

    public void movimientoBot() {

        int posicion = (int) (Math.random() * (63 - 1 + 1) + 1);

        View child = tableroEnemigo.getChildAt(posicion);
        if (child instanceof TextView) {

            if (((TextView) child).getText().equals('.')) {

                Toast.makeText(getApplicationContext(),
                        "AGUA¡",
                        Toast.LENGTH_LONG)
                        .show();
                sonidoError.start();
                ((TextView) child).setText(Character.toString(fallo));


            } else {

                Toast.makeText(getApplicationContext(),
                        "Te han golpeado¡",
                        Toast.LENGTH_LONG)
                        .show();
                sonidoAcierto.start();
                ((TextView) child).setText(Character.toString(acierto));
                puntosJugador--;
                ptosJug.setText(String.valueOf(ptosJug));
                fin = evaluarGanador();

            }

        }

        sonidoError.release();
        sonidoAcierto.release();


    }


    public int seleccionFila() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona la columna del tablero enemigo");
        builder.setItems(columnas, (dialog, pos) -> {
            switch (columnas[pos]) {

                case "A":
                    posicionFila = 0;
                    break;
                case "B":
                    posicionFila = 8;
                    break;
                case "C":
                    posicionFila = 16;
                    break;
                case "D":
                    posicionFila = 24;
                    break;
                case "E":
                    posicionFila = 32;
                    break;
                case "F":
                    posicionFila = 40;
                    break;
                case "G":
                    posicionFila = 48;
                    break;
                case "H":
                    posicionFila = 56;
                    break;
                default:
                    posicionFila = -1;

            }
        }).show();

        return posicionColumna;
    }

    public int seleccionColumna() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona la fila del tablero enemigo");
        builder.setItems(filas, (dialog, pos) -> {
            switch (filas[pos]) {

                case "1":
                    posicionColumna = 0;
                    break;
                case "2":
                    posicionColumna = 1;
                    break;
                case "3":
                    posicionColumna = 2;
                    break;
                case "4":
                    posicionColumna = 3;
                    break;
                case "5":
                    posicionColumna = 4;
                    break;
                case "6":
                    posicionColumna = 5;
                    break;
                case "7":
                    posicionColumna = 6;
                    break;
                case "8":
                    posicionColumna = 7;
                    break;
                default:
                    posicionColumna = -1;

            }
        }).show();


        return posicionFila;
    }

    //////////////////////7

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnColumna:
                seleccionColumna();
                break;

            case R.id.btnFila:
                seleccionFila();
                break;


        }

    }


    public void partida() {

        while (!fin) {

            boolean turnoJugador = false;
            int fila = -1, col = -1;

            while (turnoJugador == true) {

                fila = seleccionFila();
                col = seleccionColumna();

                if (fila > -1 && col > -1) {

                    //Se analiza la posicion escogida
                    View child = tableroEnemigo.getChildAt(fila + (col - 1));
                    if (child instanceof TextView) {

                        if (((TextView) child).getText().equals('.')) {

                            Toast.makeText(getApplicationContext(),
                                    "AGUA¡",
                                    Toast.LENGTH_LONG)
                                    .show();
                            sonidoError.start();
                            ((TextView) child).setText(Character.toString(fallo));
                            turnoJugador = false;

                        } else {

                            Toast.makeText(getApplicationContext(),
                                    "ACIERTO¡",
                                    Toast.LENGTH_LONG)
                                    .show();
                            sonidoAcierto.start();
                            ((TextView) child).setText(Character.toString(acierto));
                            turnoJugador = false;
                            puntosBot--;
                            ptosBot.setText(String.valueOf(ptosBot));
                            fin = evaluarGanador();

                        }

                    }


                }

            }

            sonidoAcierto.release();
            sonidoError.release();

            movimientoBot();

        }

        try {
            finPartida();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean evaluarGanador() {
        if (puntosJugador == 0 || puntosBot == 0) return true;
        else return false;

    }

    public void finPartida() throws InterruptedException {

        btnCol.setEnabled(false);
        btnFila.setEnabled(false);

        Toast.makeText(getApplicationContext(),
                "Fin de partida¡",
                Toast.LENGTH_LONG)
                .show();

        Thread.sleep(1000);

        if (puntosJugador == 0) {

            Toast.makeText(getApplicationContext(),
                    "PERDISTE¡",
                    Toast.LENGTH_LONG)
                    .show();

        } else if (puntosBot == 0) {
            Toast.makeText(getApplicationContext(),
                    "GANASTE¡",
                    Toast.LENGTH_LONG)
                    .show();
        }

    }
}