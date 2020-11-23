package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaController.MediaPlayerControl {

    private VideoView videoView;
    private MediaController mediaController;
    Uri url = Uri.parse("android.resource://" + "com.example.videoview" + "/" + R.raw.hedgehog_bites_girl_foot);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView)findViewById(R.id.video_view);
        videoView.setVideoPath(url.toString());
        mediaController = new MediaController(MainActivity.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();
    }


    @Override
    public void start() {
        videoView.start();
    }

    @Override
    public void pause() {
        videoView.pause();
    }

    @Override
    public int getDuration() {
        return videoView.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return videoView.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        videoView.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return true;
    }

    @Override
    public int getBufferPercentage() {
        return videoView.getBufferPercentage();
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}