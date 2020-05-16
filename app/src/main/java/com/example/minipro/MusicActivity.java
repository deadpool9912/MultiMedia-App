package com.example.minipro;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MusicActivity extends AppCompatActivity {
        MediaPlayer Mysong;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Mysong=MediaPlayer.create(MusicActivity.this,R.raw.song);
        }
public void Play(View v)
        {
        Mysong.start();
        }

    @Override
    protected void onPause() {
        super.onPause();
        Mysong.release();
    }
}

