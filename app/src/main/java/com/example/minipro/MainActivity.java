package com.example.minipro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Call(View v)
    {
        Intent c = new Intent(this,CallActivity.class);
        startActivity(c);
    }
    public void Message(View v)
    {
        Intent c = new Intent(this,MessageActivity.class);
        startActivity(c);
    }
    public void Song(View v)
    {
        Intent c = new Intent(this,MusicActivity.class);
        startActivity(c);
    }
    public void Internet(View v)
    {
        Intent c = new Intent(this,WebActivity.class);
        startActivity(c);
    }
}
