package com.example.examen1eval1_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private ListView listado;
    private MediaPlayer mediaPlayer = null;
    private ArrayList<String> audios;
    private boolean esPlay = false, esPause = false, esStop = false;
    private AudioManager audioManager;

    RadioGroup r;
    RadioButton bajo, medio, alto;
    CheckBox loop;

    Button btnPlay = null, btnPause = null, btnStop = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = (ListView) findViewById(R.id.list_item);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        }

        r = (RadioGroup) findViewById(R.id.volumenes);
        r.setOnCheckedChangeListener(this);
        bajo = (RadioButton) findViewById(R.id.btnBajo);
        medio = (RadioButton) findViewById(R.id.btnMedio);
        alto = (RadioButton) findViewById(R.id.btnAlto);
        loop = (CheckBox) findViewById(R.id.chkLoop);

        btnPlay = (Button) findViewById(R.id.play);
        btnPause = (Button) findViewById(R.id.pause);
        btnStop = (Button) findViewById(R.id.stop);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        audios = new ArrayList<String>();

        audios.add("Elefante");
        audios.add("Caballo");
        audios.add("Gato");
        audios.add("Leon");
        audios.add("Pajaro");
        audios.add("Perro");

        ArrayAdapter<String> adaptadorTalleres = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                audios
        );

        listado.setAdapter(adaptadorTalleres);

        // Evento click sobre cada elemento de la lista
        listado.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {

            case 0:

                mediaPlayer = MediaPlayer.create(this, R.raw.elefante);

                break;


            case 1:

                mediaPlayer = MediaPlayer.create(this, R.raw.caballo);

                break;


            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.gato);

                break;


            case 3:

                mediaPlayer = MediaPlayer.create(this, R.raw.leon);

                break;


            case 4:

                mediaPlayer = MediaPlayer.create(this, R.raw.pajaro);

                break;


            case 5:

                mediaPlayer = MediaPlayer.create(this, R.raw.perro);


                break;


            default:

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.play:


                if (mediaPlayer != null) {

                    mediaPlayer.start();
                    esPlay = true;
                } else if (esPlay) {

                    Toast.makeText(getApplicationContext(),
                            "Ya está sonando",
                            Toast.LENGTH_LONG)
                            .show();

                } else {

                    Toast.makeText(getApplicationContext(),
                            "Pulsa antes en un animal de la lista.",
                            Toast.LENGTH_LONG)
                            .show();


                }


                break;

            case R.id.pause:


                if (esPlay) {


                    mediaPlayer.pause();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Reproduce antes un sonido",
                            Toast.LENGTH_LONG)
                            .show();
                }

                break;

            case R.id.stop:

                if (esPlay) {
                    mediaPlayer.stop();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Reproduce antes un sonido",
                            Toast.LENGTH_LONG)
                            .show();
                }
                break;


        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        switch (checkedId) {

            case R.id.btnBajo:

                float percentq = 0.25f;
                int quarter = (int) (maxVolume * percentq);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, quarter, 0);

                break;
            case R.id.btnMedio:

                float percenth = 0.5f;
                int half = (int) (maxVolume * percenth);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, half, 0);

                break;
            case R.id.btnAlto:


                float percent = 1f;
                int full = (int) (maxVolume * percent);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, full, 0);

                break;

            case R.id.chkLoop:

                mediaPlayer.setLooping(true);

                break;

        }


    }
}