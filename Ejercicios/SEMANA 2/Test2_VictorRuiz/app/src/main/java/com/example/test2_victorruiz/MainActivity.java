package com.example.test2_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup r;
    RadioButton radioButton, radioButton2, radioButton4, radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                r=(RadioGroup)findViewById(R.id.radioG);
        r.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        TextView t=(TextView)findViewById(R.id.textView);
        switch(checkedId){
            case R.id.radioButton2: //Talavera
                t.setText("Buena elección!: El Talavera  promete!!");
                break;
            case R.id.radioButton3: //Alcazar
                t.setText("Gran equipo la gimnástica!!");
                break;
            case R.id.radioButton: //Albacete
                t.setText("El Albacete no es el mismo desde que se fué Iniesta");
                break;
            case R.id.radioButton4: //Otros
                t.setText("El dinero no lo es todo....");
                break;
        }

    }
}