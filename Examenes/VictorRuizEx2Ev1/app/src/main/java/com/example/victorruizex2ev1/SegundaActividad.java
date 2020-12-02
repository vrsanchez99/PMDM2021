package com.example.victorruizex2ev1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActividad extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private Button btnVolver;
    private TextView textDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        btnVolver = (Button) findViewById(R.id.button);
        textDesc = (TextView) findViewById(R.id.textDescripcion);

        Bundle recibir = getIntent().getExtras();

        String nombre = recibir.getString("NOMBRE");
        String descripción = recibir.getString("DESCRIPCION");

        Toast.makeText(SegundaActividad.this, descripción, Toast.LENGTH_LONG).show();

        // textDesc.setText(descripción+"");

        btnVolver.setOnClickListener(this);


        reproducirSonido(nombre);

    }

    public void reproducirSonido(String nombre) {

        switch (nombre) {

            case "BUHO":

                mediaPlayer = MediaPlayer.create(this, R.raw.buho);
                mediaPlayer.setLooping(true);

                break;
            case "COLIBRÍ":

                mediaPlayer = MediaPlayer.create(this, R.raw.colibri);
                mediaPlayer.setLooping(true);

                break;


            case "CUERVO":

                mediaPlayer = MediaPlayer.create(this, R.raw.cuervo);
                mediaPlayer.setLooping(true);
                break;


            case "FLAMENCO":

                mediaPlayer = MediaPlayer.create(this, R.raw.flamenco);
                mediaPlayer.setLooping(true);
                break;

            case "KIWI":

                mediaPlayer = MediaPlayer.create(this, R.raw.kiwi);
                mediaPlayer.setLooping(true);
                break;

            case "LORO":

                mediaPlayer = MediaPlayer.create(this, R.raw.loro);
                mediaPlayer.setLooping(true);
                break;

            case "PAVO":

                mediaPlayer = MediaPlayer.create(this, R.raw.pavo);
                mediaPlayer.setLooping(true);
                break;

            case "PINGÜINO":

                mediaPlayer = MediaPlayer.create(this, R.raw.pinguino);
                mediaPlayer.setLooping(true);
                break;

        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button:
                finish();
                break;
        }
    }
}