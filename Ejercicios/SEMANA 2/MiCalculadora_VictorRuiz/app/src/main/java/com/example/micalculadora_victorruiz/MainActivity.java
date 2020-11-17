package com.example.micalculadora_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText campoNumeros;
    Button btnC, btnIgual;
    Button btnSuma, btnResta, btnMult, btnDiv, btnMod;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot;
    float num1 = 0, num2 = 0;
    float decimal=0.0f;
    String aux = "";
    boolean suma=false, resta=false, mult=false, div=false, mod=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNumeros = (EditText) findViewById(R.id.campoRes);
        campoNumeros.setEnabled(false);
        btnC = (Button) findViewById(R.id.btnC);

        //Botones de operaciones
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMod = (Button) findViewById(R.id.btnMod);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnDot = (Button)findViewById(R.id.btnDot);

        //Botones de digitos
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);

        //Listeners
        btnC.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMod.setOnClickListener(this);

        btn0.setOnClickListener(this);
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
            case R.id.btnC:
                campoNumeros.setText("");

                num1 =0;
                num2=0;
                break;

            case R.id.btnIgual:

                if(suma || resta || div || mult || mod){
               num2 = Integer.parseInt(campoNumeros.getText().toString());
                }

                if(suma){
                    campoNumeros.setText(String.valueOf(suma(num1,num2)));
                    suma=false;
                } else if(resta){
                    campoNumeros.setText(String.valueOf(resta(num1, num2)));
                    resta = false;
                } else if(mult){
                    campoNumeros.setText(String.valueOf(mult(num1, num2)));
                    mult = false;
                } else if(div){
                    campoNumeros.setText(String.valueOf(div(num1, num2)));
                    div = false;
                } else if(mod) {
                    campoNumeros.setText(String.valueOf(mod(num1, num2)));
                    mod = false;
                }


                break;
            case R.id.btn0:
                campoNumeros.setText(campoNumeros.getText() + "0");
                break;

            case R.id.btn1:
                campoNumeros.setText(campoNumeros.getText() + "1");
                break;

            case R.id.btn2:
                campoNumeros.setText(campoNumeros.getText() + "2");
                break;

            case R.id.btn3:
                campoNumeros.setText(campoNumeros.getText() + "3");
                break;

            case R.id.btn4:
                campoNumeros.setText(campoNumeros.getText() + "4");
                break;

            case R.id.btn5:
                campoNumeros.setText(campoNumeros.getText() + "5");
                break;

            case R.id.btn6:
                campoNumeros.setText(campoNumeros.getText() + "6");
                break;

            case R.id.btn7:
                campoNumeros.setText(campoNumeros.getText() + "7");
                break;

            case R.id.btn8:
                campoNumeros.setText(campoNumeros.getText() + "8");
                break;

            case R.id.btn9:
                campoNumeros.setText(campoNumeros.getText() + "9");
                break;

            case R.id.btnDot:
                if(!campoNumeros.getText().toString().contains(".")) {
                    campoNumeros.setText(campoNumeros.getText() + ".");
                } else{
                    //
                }
                break;
            case R.id.btnSuma:

                if(campoNumeros.getText().length()!=0) {

                    num1 = Float.parseFloat(campoNumeros.getText().toString());

                    if(campoNumeros.getText().toString().contains(".")){
                        decimal = num1;
                    }
                        suma = true;
                        campoNumeros.setText("");

                } else {

                    Toast.makeText(getApplicationContext(),
                            "Introduce algún número primero!",
                            Toast.LENGTH_LONG)
                            .show();
                }

                break;

            case R.id.btnResta:

                if(campoNumeros.getText().length()!=0) {
                    num1 = Float.parseFloat(campoNumeros.getText().toString());

                    if(campoNumeros.getText().toString().contains(".")){
                        decimal = num1;
                    }
                    resta = true;
                    campoNumeros.setText("");

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Introduce algún número primero!",
                            Toast.LENGTH_LONG)
                            .show();

                }

                break;

            case R.id.btnDiv:

                if(campoNumeros.getText().length()!=0) {
                    num1 = Float.parseFloat(campoNumeros.getText().toString());

                    if(campoNumeros.getText().toString().contains(".")){
                        decimal = num1;
                    }
                    div = true;
                    campoNumeros.setText("");

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Introduce algún número primero!",
                            Toast.LENGTH_LONG)
                            .show();

                }

                break;


            case R.id.btnMult:

                if(campoNumeros.getText().length()!=0) {
                    num1 = Float.parseFloat(campoNumeros.getText().toString());

                    if(campoNumeros.getText().toString().contains(".")){
                        decimal = num1;
                    }
                    mult = true;
                    campoNumeros.setText("");

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Introduce algún número primero!",
                            Toast.LENGTH_LONG)
                            .show();

                }

                break;

            case R.id.btnMod:

                if(campoNumeros.getText().length()!=0) {
                    num1 = Float.parseFloat(campoNumeros.getText().toString());

                    if(campoNumeros.getText().toString().contains(".")){
                        decimal = num1;
                    }
                    mod = true;
                    campoNumeros.setText("");

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Introduce algún número primero!",
                            Toast.LENGTH_LONG)
                            .show();

                }

                break;

            default:

        }


    }

    /**
     * @param num1
     * @param num2
     * @return
     */
    public float suma(float num1, float num2) {
        return num1 + num2;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public float resta(float num1, float num2) {
        return num1 - num2;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public float mult(float num1, float num2) {
        return num1 * num2;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public float div(float num1, float num2) {
        if (num2 != 0){
            return (float) num1 / num2;}
        else {
            Toast.makeText(getApplicationContext(),
                    "Error. División entre 0!!",
                    Toast.LENGTH_LONG)
                    .show();
            return 0;
        }

    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public float mod(float num1, float num2){
        if (num2 != 0){
            return (float) num1 % num2;}
        else {
            Toast.makeText(getApplicationContext(),
                    "Error. División entre 0!!",
                    Toast.LENGTH_LONG)
                    .show();
            return 0;
        }
    }
}