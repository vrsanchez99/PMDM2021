package com.example.tresenraya_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView ganador;
    boolean turno = false;

    GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ganador = (TextView) findViewById(R.id.textViewWinner);
        ganador.setVisibility(View.INVISIBLE);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        grid = (GridLayout) findViewById(R.id.gridLayout);

        //Listener de los botones


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn1:

                if (btn1.getText().toString().equals("")) {

                    btn1.setText("X");
                    bot();
                    ganador();


                }


                break;


            case R.id.btn2:


                if (btn2.getText().toString().equals("")) {

                    btn2.setText("X");
                    bot();
                    ganador();


                }


                break;


            case R.id.btn3:

                if (btn3.getText().toString().equals("")) {

                    btn3.setText("X");

                    bot();
                    ganador();


                }


                break;

            case R.id.btn4:

                if (btn4.getText().toString().equals("")) {

                    btn4.setText("X");
                    bot();
                    ganador();

                }


                break;


            case R.id.btn5:

                if (btn5.getText().toString().equals("")) {

                    btn5.setText("X");
                    bot();
                    ganador();


                }


                break;

            case R.id.btn6:
                if (btn6.getText().toString().equals("")) {

                    btn6.setText("X");
                    bot();
                    ganador();

                }


                break;


            case R.id.btn7:

                if (btn7.getText().toString().equals("")) {

                    bot();
                    ganador();

                }

                break;


            case R.id.btn8:

                if (btn8.getText().toString().equals("")) {


                    btn8.setText("X");
                    bot();
                    ganador();


                }

                break;


            case R.id.btn9:

                if (btn9.getText().toString().equals("")) {

                    btn9.setText("X");
                    bot();
                    ganador();

                }


                break;

        }
    }

    public void bot() {

        boolean flag = false;

        while (!flag) {

            int posicion = (int) (Math.random() * (9 - 1 + 1) + 1);
            View child = grid.getChildAt(posicion);
            if (child instanceof Button) {
                if (((Button) child).getText().toString().equals("")){
                    ((Button) child).setText("O");
                flag = true;}
            }

        }


    }

    public void ganador() {


        if ((btn1.getText().toString().equals("X") && btn2.getText().toString().equals("X") && btn3.getText().toString().equals("X")) ||
                (btn4.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn6.getText().toString().equals("X")) ||
                (btn7.getText().toString().equals("X") && btn8.getText().toString().equals("X") && btn9.getText().toString().equals("X")) ||
                (btn1.getText().toString().equals("X") && btn4.getText().toString().equals("X") && btn7.getText().toString().equals("X")) ||
                (btn2.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn8.getText().toString().equals("X")) ||
                (btn3.getText().toString().equals("X") && btn6.getText().toString().equals("X") && btn9.getText().toString().equals("X")) ||
                btn1.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn9.getText().toString().equals("X") ||
                btn3.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn7.getText().toString().equals("X")) {

            ganador.setVisibility(View.VISIBLE);
            ganador.setText("GANASTE¡");
            bloquearTablero();

        } else if ((btn1.getText().toString().equals("O") && btn2.getText().toString().equals("O") && btn3.getText().toString().equals("O")) ||
                (btn4.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn6.getText().toString().equals("O")) ||
                (btn7.getText().toString().equals("O") && btn8.getText().toString().equals("O") && btn9.getText().toString().equals("O")) ||
                (btn1.getText().toString().equals("O") && btn4.getText().toString().equals("O") && btn7.getText().toString().equals("O")) ||
                (btn2.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn8.getText().toString().equals("O")) ||
                (btn3.getText().toString().equals("O") && btn6.getText().toString().equals("O") && btn9.getText().toString().equals("O")) ||
                (btn1.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn9.getText().toString().equals("O")) ||
                (btn3.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn7.getText().toString().equals("O"))) {


            ganador.setVisibility(View.VISIBLE);
            ganador.setText("Has perdido¡");
            bloquearTablero();

        }

    }

    public void bloquearTablero() {


        for (int i = 0; i < grid.getChildCount(); i++) {
            View child = grid.getChildAt(i);
            child.setEnabled(false);
        }

    }
}