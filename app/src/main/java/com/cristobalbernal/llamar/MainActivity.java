package com.cristobalbernal.llamar;

import androidx.annotation.NonNull;
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
    String pare = "637336566";
    String jorda = "644309410";
    public static final int REQUEST_CALL_PHONE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btPare = findViewById(R.id.btPare);
        btJordan = findViewById(R.id.btJordan);
        btPare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamarPersonas(pare);
            }
        });
        btJordan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamarPersonas(jorda);
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CALL_PHONE:
                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //llamarPersonas();
                }
                break;
        }
    }
}