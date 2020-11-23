package com.example.multimedia_victorruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer = null;
    private Button play, pause, stop, playSp, pauseSp, stopSp;
    private SoundPool sp;
    private int musicStream = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ejemplo con MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.labebesitabebelean);


        play = (Button) findViewById(R.id.btnPlay);
        pause = (Button) findViewById(R.id.btnPause);
        stop = (Button) findViewById(R.id.btnStop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

        //Ejemplo con SoundPool

        playSp = (Button) findViewById(R.id.btnPlaySp);
        pauseSp = (Button) findViewById(R.id.btnPauseSp);
        stopSp = (Button) findViewById(R.id.btnStopSp);

        playSp.setOnClickListener(this);
        pauseSp.setOnClickListener(this);
        stopSp.setOnClickListener(this);

        sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        musicStream = sp.load(this, R.raw.labebesitabebelean, 1);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnPlay:

                mediaPlayer.start();

                break;

            case R.id.btnPause:

                mediaPlayer.pause();

                break;

            case R.id.btnStop:

                mediaPlayer.stop();
                mediaPlayer.release();
                break;


            case R.id.btnPlaySp:

                sp.play(musicStream, 1, 1, 0, 0, 1);

                break;

            case R.id.btnPauseSp:

                sp.pause(AudioManager.STREAM_MUSIC);

                break;

            case R.id.btnStopSp:

                sp.stop(AudioManager.STREAM_MUSIC);

                break;

        }

    }
}