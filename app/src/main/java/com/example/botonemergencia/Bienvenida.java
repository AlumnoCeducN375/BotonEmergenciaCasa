package com.example.botonemergencia;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {
    EditText usuario, nombre, apellido, contrasena, email, direccion, telefono ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        usuario=(EditText) findViewById(R.id.txtDisplayUsuario);
        nombre=(EditText) findViewById(R.id.txtDisplayNombre);
        apellido=(EditText) findViewById(R.id.txtDisplayApellido);
        contrasena=(EditText) findViewById(R.id.txtDisplayContrasena);
        email=(EditText) findViewById(R.id.txtDisplayEmail);
        direccion=(EditText) findViewById(R.id.txtDisplayDireccion);
        telefono=(EditText) findViewById(R.id.txtDisplayTelefono);
    }

    public void consultarUsuario (View view)
    {
        ConexionBD baseDeDatosUsuario = new ConexionBD(this, "TablaDatosUsuario",null,1 );
        SQLiteDatabase editableDB = baseDeDatosUsuario.getWritableDatabase();

        String userAux = usuario.getText().toString();
        if(!userAux.isEmpty())
        {
            Cursor registro = editableDB.rawQuery("select usuario, nombre, apellido, contrasena, telefono, email, direccion where usuario LIKE '%"+userAux+"%'",null);
            if (registro.moveToFirst())
            {
                usuario.setText(registro.getString(0));
                nombre.setText(registro.getString(1));
                apellido.setText(registro.getString(2));
                contrasena.setText(registro.getString(3));
                email.setText(registro.getString(4));
                direccion.setText(registro.getString(5));
                telefono.setText(registro.getString(6));
                editableDB.close();
            }
            else
            {
                Toast.makeText(this, "No existe el Usuario", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Complete el Usuario", Toast.LENGTH_SHORT).show();
        }
    }



}