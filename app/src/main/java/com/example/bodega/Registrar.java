package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {

    EditText us, pas, nomb, ape;
    Button reg, can;
    DaoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        us=(EditText) findViewById(R.id.etUsuario);
        pas=(EditText) findViewById(R.id.etpass);
        nomb=(EditText) findViewById(R.id.etnombre);
        ape=(EditText) findViewById(R.id.etApellidos);

        reg=(Button) findViewById(R.id.btnIngresar);
        can=(Button) findViewById(R.id.btnCancelar);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao = new DaoUsuario(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIngresar:
                Usuarios u = new Usuarios();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setNombre(nomb.getText().toString());
                u.setApellidos(ape.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this, "ERROR: campos vacios", Toast.LENGTH_LONG).show();
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this,"Registro exitoso!!!", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(Registrar.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                }

            case R.id.btnCancelar:
                Intent i3 = new Intent(Registrar.this,principal.class);
                startActivity(i3);
                break;
        }
    }
}