package com.example.botonemergencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario extends AppCompatActivity
{
    private EditText nombreUsuario, apellidoUsuario, usuarioUsuario, contrasenaUsuario, telefonoUsuario, emailUsuario, direccionUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombreUsuario=(EditText) findViewById(R.id.txtNombre);
        apellidoUsuario=(EditText) findViewById(R.id.txtApellido);
        usuarioUsuario=(EditText) findViewById(R.id.txtUsuario);
        contrasenaUsuario=(EditText) findViewById(R.id.txtPass);
        telefonoUsuario=(EditText) findViewById(R.id.txtTelefono);
        emailUsuario=(EditText) findViewById(R.id.txtDireccion);
        direccionUsuario=(EditText) findViewById(R.id.txtDireccion);
    }

    public void avanzarDatosEmergencia(View view)
    {
        Intent avanzarEmerg = new Intent(this,DatosEmergencia.class);
        startActivity(avanzarEmerg);
    }
    public void crearUsuario(View view)
    {
        String usuarioAux = usuarioUsuario.getText().toString();

        if(usuarioAux.isEmpty())
        {
            Toast.makeText(this, "Ingrese un Usuario", Toast.LENGTH_SHORT).show();
        }

        ConexionBD baseDeDatosUsuario = new ConexionBD(this, "TablaDatosUsuario",null,1);
        SQLiteDatabase editableDB = baseDeDatosUsuario.getWritableDatabase();
        String usuarioImportante1= usuarioUsuario.getText().toString();
        String nombreImportante1= nombreUsuario.getText().toString();
        String apellidoImportante1=apellidoUsuario.getText().toString();
        String contrasenaImportante1=contrasenaUsuario.getText().toString();
        String telefonoImportante1=telefonoUsuario.getText().toString();
        String emailImportante1= emailUsuario.getText().toString();
        String direccionImportante1=direccionUsuario.getText().toString();

        ContentValues paqueteUsuario = new ContentValues();
        paqueteUsuario.put("usuario",usuarioImportante1);
        paqueteUsuario.put("nombre",nombreImportante1);
        paqueteUsuario.put("apellido",apellidoImportante1);
        paqueteUsuario.put("contraseña",contrasenaImportante1);
        paqueteUsuario.put("telefono",telefonoImportante1);
        paqueteUsuario.put("email",emailImportante1);
        paqueteUsuario.put("direccion",direccionImportante1);

        editableDB.insert("datosUsuarios",null,paqueteUsuario);
        usuarioUsuario.setText("");
        nombreUsuario.setText("");
        apellidoUsuario.setText("");
        contrasenaUsuario.setText("");
        telefonoUsuario.setText("");
        emailUsuario.setText("");
        direccionUsuario.setText("");
        editableDB.close();



        Toast.makeText(this, "Usuario creado Correctamente", Toast.LENGTH_SHORT).show();
    }




}