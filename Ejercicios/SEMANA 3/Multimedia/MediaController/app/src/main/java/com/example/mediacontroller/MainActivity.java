package com.example.mediacontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaController.MediaPlayerControl {

    MediaController mediaController;
    MediaPlayer mediaPlayer;
    //private Button play, pause, stop;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaController = new MediaController(this);
        mediaPlayer = new MediaPlayer();

//        play = (Button) findViewById(R.id.btnPlay);
//        pause = (Button) findViewById(R.id.btnPause);
//        stop = (Button) findViewById(R.id.btnStop);

        mediaPlayer.setOnPreparedListener(this);
        AssetFileDescriptor afd = this.getResources().openRawResourceFd(R.raw.i_love_being_with_you);
        try {
           mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            Log.e("MediaPlayer", "Could not open file " + R.raw.i_love_being_with_you + " for playback.", e);
        }

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.d("MediaController", "onPrepared");
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(findViewById(R.id.textView));

        handler.post(new Runnable() {
            public void run() {
                mediaController.setEnabled(true);
                mediaController.show(10000);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mediaController.show(); return false;
    }

    @Override
    public void start() {
        mediaPlayer.start();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mediaPlayer.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaController.hide();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

}