package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=(TextView) findViewById(R.id.tv1);
        b=(TextView) findViewById(R.id.tv2);
    }
/*
    EditText user, pass;
    Button btnEntrar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText) findViewById(R.id.etUsuario);
        pass=(EditText) findViewById(R.id.etpass);
        btnEntrar=(Button) findViewById(R.id.btnIngresar);
        btnRegistrar=(Button) findViewById(R.id.btnCancelar);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIngresar:
                if (user.getText().equals("Usuario") && pass.getText().equals("Contraseña"))
                    Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancelar:
                Intent i = new Intent(MainActivity.this,Registrar.class);
                startActivity(i);
                break;
        }
    }*/
}