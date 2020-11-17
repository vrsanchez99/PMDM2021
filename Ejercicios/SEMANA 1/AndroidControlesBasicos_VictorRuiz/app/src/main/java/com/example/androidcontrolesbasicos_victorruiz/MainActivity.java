package com.example.androidcontrolesbasicos_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button boton, aceptar, cancelar;
    private Button botonSinBorde = null;
    private Button botonImagen = null;
    private ToggleButton toggleButton = null;
    private Switch aSwitch = null;
    private ImageButton imageButton = null;
    private CheckBox checkbox;
    private RadioGroup radioGroup;
    private RadioButton op1, op2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkbox = (CheckBox)findViewById(R.id.chkMarcame) ;
        aceptar = (Button) findViewById(R.id.btnAceptar);
        cancelar = (Button) findViewById(R.id.btnCancelar);
        boton = (Button) findViewById(R.id.button);
        botonSinBorde = (Button) findViewById(R.id.borderlessButton);
        botonImagen = (Button) findViewById(R.id.btnBotonMasImagen);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        aSwitch = (Switch) findViewById(R.id.switch1);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setClickable(true);
        radioGroup = (RadioGroup) findViewById(R.id.grbGrupo1);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Toast.makeText(getApplicationContext(), "marcado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "desmarcado", Toast.LENGTH_SHORT).show();
                }
            }
        });


        radioGroup.setOnClickListener(this);
        boton.setOnClickListener(this);
        aceptar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
        botonSinBorde.setOnClickListener(this);
        botonImagen.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Toast.makeText(getApplicationContext(), toggleButton.getTextOn(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), toggleButton.getTextOff(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "switch on", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "switch off", Toast.LENGTH_SHORT).show();
                }
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                oyenteRadioGroup(group, checkedId);
            }
        });

    }


    /**
     *
     * @param radioGroup
     * @param opcionMarcada
     */
    public void oyenteRadioGroup(RadioGroup radioGroup, int opcionMarcada) {

        int opcion = radioGroup.getCheckedRadioButtonId();

        if (opcion == R.id.rbOpcion1) {

            Toast.makeText(getApplicationContext(), "Opcion 1 radiogroup", Toast.LENGTH_SHORT).show();

        } else if (opcion == R.id.rbOpcion2) {

            Toast.makeText(getApplicationContext(), "Opcion 2 radiogroup", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button:

                Toast.makeText(getApplicationContext(),
                        "Botón normal pulsado",
                        Toast.LENGTH_LONG).show();

                break;

            case R.id.borderlessButton:

                Toast.makeText(getApplicationContext(),
                        "Botón sin bordes pulsado.",
                        Toast.LENGTH_LONG).show();

                break;


            case R.id.btnBotonMasImagen:

                Toast.makeText(getApplicationContext(),
                        "Botón más imagen.",
                        Toast.LENGTH_LONG).show();

                break;

            case R.id.imageButton:

                Toast.makeText(getApplicationContext(),
                        "ImageButton pulsado",
                        Toast.LENGTH_LONG).show();

                break;
            case R.id.btnAceptar:
                Toast.makeText(getApplicationContext(),
                        "ACEPTAR",
                        Toast.LENGTH_LONG).show();

                break;


            case R.id.btnCancelar:
                Toast.makeText(getApplicationContext(),
                        "CANCELAR",
                        Toast.LENGTH_LONG).show();

                break;


        }


    }


}