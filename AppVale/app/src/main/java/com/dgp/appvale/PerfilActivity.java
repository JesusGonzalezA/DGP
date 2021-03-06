package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;

import com.dgp.appvale.clases.Data;
import com.dgp.appvale.clases.Sistema;
import com.dgp.appvale.clases.Socio;

public class PerfilActivity extends AppCompatActivity implements  View.OnClickListener {
    private TextView nombrePerfil, apellidosPerfil, fechaNacPerfil;
    private ImageView iconoAvatar;
    private ImageButton botonAtrasPerfil;

    private Sistema sistema;

    private void init(){
        nombrePerfil = findViewById(R.id.nombrePerfil);
        apellidosPerfil = findViewById(R.id.apellidosPerfil);
        fechaNacPerfil = findViewById(R.id.fechaNacPerfil);
        iconoAvatar = findViewById(R.id.imagenAvatar);
        botonAtrasPerfil = findViewById(R.id.botonAtrasPerfil);

        sistema = new Sistema();
    }

    private void generarDatosPerfil(){
        nombrePerfil.setText("Nombre: " + Data.getData().getSocio().getNombre());
        apellidosPerfil.setText("Apellidos: " + Data.getData().getSocio().getApellidos());
        fechaNacPerfil.setText("FechaNac: " + Data.getData().getSocio().getFechaNacimiento());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        init();
        generarDatosPerfil();

        botonAtrasPerfil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        finish();
    }
}