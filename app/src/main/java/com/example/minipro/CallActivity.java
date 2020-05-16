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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    private EditText Number;
    private Button Call;

    private static final int CALL_PERMISSION_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Number = findViewById(R.id.Number);
        Call = findViewById(R.id.Call);
       Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }
    private void makePhoneCall()
    {
        String num = Number.getText().toString();
        if(num.trim().length() > 0)
        {
            if(ContextCompat.checkSelfPermission(CallActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(CallActivity.this,new String[]{Manifest.permission.CALL_PHONE},CALL_PERMISSION_CODE);
            }
            else
            {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+num)));
            }
        }
        else
        {
            Toast.makeText(CallActivity.this,"Enter Valid Phone Number",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CALL_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else
                Toast.makeText(this, "please Give Permission", Toast.LENGTH_SHORT).show();
        }
    }
}

