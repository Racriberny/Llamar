package com.cristobalbernal.llamar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btPare;
    Button btJordan;
    public static final int REQUEST_CALL_PHONE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btPare = findViewById(R.id.btPare);
        btJordan = findViewById(R.id.btJordan);
        btPare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamarPersonas("637336566");
            }
        });
        btJordan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamarPersonas("644309410");
            }
        });
    }

    private void llamarPersonas(String tel) {
        int permision = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permision != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tel));
            startActivity(callIntent);
        }
    }
}