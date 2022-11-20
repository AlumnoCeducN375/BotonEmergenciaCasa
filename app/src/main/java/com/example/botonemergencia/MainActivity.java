package com.example.botonemergencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cambiarFormulario(View view)
    {
        Intent cambiarVentana1 = new Intent(this, Formulario.class);
        startActivity(cambiarVentana1);
    }
    public void cambiarBienvenida(View view)
    {
        Intent cambiarVentanaBienvenida = new Intent(this, Bienvenida.class);
        startActivity(cambiarVentanaBienvenida);
    }
}