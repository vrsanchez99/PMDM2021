package com.example.buscaminas_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    private GridLayout tablero;
    private boolean gameOver = false;
    private int bombas = 10;
    private final int size = 8;
    private char[][] tableroAuxiliar;
    private boolean minasColocadas = false;

    private char bomba = 'b';
    private char bombaEncontrada = 'x';
    private char flag = 'f';
    private char hidden = '.';
    private char clear = 'c';

    private Random rand = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablero = (GridLayout) findViewById(R.id.gridTablero);
        tablero.setColumnCount(size);
        tablero.setRowCount(size);
        tableroAuxiliar = new char[size][size];


    }


    public ImageView casilla() {

        ImageView casilla = new ImageView(this);
        casilla.setLayoutParams(new ViewGroup.LayoutParams(
                50,
                50));
        casilla.setBackgroundColor(Color.GRAY);

        return casilla;
    }


    public void colocarMinasEnTablero() {

        for(int i=0; i < size ;i++){
            for(int j=0; j < size; j++){




            }
        }



    }


    public void colocarBandera() {

    }


    public void game() {

    }

    /// EVENT METHODS

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {



        return false;
    }
}