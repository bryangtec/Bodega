package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class principal extends AppCompatActivity {
    TextView a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //a=(TextView) findViewById(R.id.tv1);
        //b=(TextView) findViewById(R.id.tv2);
    }
}