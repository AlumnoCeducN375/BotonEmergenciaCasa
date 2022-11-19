package com.example.botonemergencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DatosEmergencia extends AppCompatActivity
{

    EditText nombreContacto1 , telefonoContacto1, nombreContacto2, telefonoContacto2, nombreContacto3, telefonoContacto3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_emergencia);

        nombreContacto1= (EditText) findViewById(R.id.txtNombreContacto1);
        telefonoContacto1=(EditText) findViewById(R.id.txtTelefContacto1);
        nombreContacto2=(EditText) findViewById(R.id.txtNombreContacto2);
        telefonoContacto2=(EditText) findViewById(R.id.txtTelefContacto2);
        nombreContacto3=(EditText) findViewById(R.id.txtNombreContacto3);
        telefonoContacto3=(EditText) findViewById(R.id.txtTelefContacto3);


    }



    public void crearContactosEmergencia(View view)
    {

        ConexionBD baseDeDatosEmergencia = new ConexionBD(this,"TablaDatosEmergencia",null,1);
        SQLiteDatabase editableDB = baseDeDatosEmergencia.getWritableDatabase();
        String nombre1 = nombreContacto1.getText().toString();
        String telefono1 = telefonoContacto1.getText().toString();
        String nombre2 = nombreContacto2.getText().toString();
        String telefono2 = telefonoContacto2.getText().toString();
        String nombre3 =nombreContacto3.getText().toString();
        String telefono3= telefonoContacto3.getText().toString();

        ContentValues paqueteDatosEmergencia = new ContentValues();
        paqueteDatosEmergencia.put("nombreDato1", nombre1);
        paqueteDatosEmergencia.put("telefonoDato1",telefono1);
        paqueteDatosEmergencia.put("nombreDato2", nombre2);
        paqueteDatosEmergencia.put("telefonoDato2", telefono2);
        paqueteDatosEmergencia.put("nombreDato3", nombre3);
        paqueteDatosEmergencia.put("telefonoDato3", telefono3);

        editableDB.insert("datosEmergencia",null,paqueteDatosEmergencia);
        nombreContacto1.setText("");
        telefonoContacto1.setText("");
        nombreContacto2.setText("");
        telefonoContacto2.setText("");
        nombreContacto3.setText("");
        telefonoContacto3.setText("");
        editableDB.close();
        Toast.makeText(this, "Datos de Emergencia creados Correctamente", Toast.LENGTH_SHORT).show();
    }

    public void volverAFormulario(View view){
        Intent volverForm = new Intent(this,Formulario.class);
        startActivity(volverForm);
    }
}