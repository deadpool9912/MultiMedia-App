package com.example.minipro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {
    private EditText Number,Message;
    private Button Send;

    private static final int MSEND_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Number = findViewById(R.id.Number);
        Message =findViewById(R.id.Message);
        Send = findViewById(R.id.Send);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMessage();
            }
        });
    }
    private void SendMessage()
    {
        String num = Number.getText().toString();
        String mes = Message.getText().toString().trim();
        if(num.trim().length() > 0 && mes.length()>0)
        {
            if(ContextCompat.checkSelfPermission(MessageActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MessageActivity.this,new String[]{Manifest.permission.SEND_SMS},MSEND_PERMISSION_CODE);
            }
            else
            {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(num,null,mes,null,null);
                Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(MessageActivity.this,"Enter Valid Filed Data",Toast.LENGTH_SHORT).show();
        }
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MSEND_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                SendMessage();
            } else
                Toast.makeText(this, "please Give Permission", Toast.LENGTH_SHORT).show();
        }
    }
}
