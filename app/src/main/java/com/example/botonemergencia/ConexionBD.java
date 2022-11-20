package com.example.botonemergencia;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionBD extends SQLiteOpenHelper{


    public ConexionBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table datosUsuarios (usuario varchar(50) primary key not null, nombre varchar(50),apellido varchar(50),contrasena cvarchar(50), telefono varchar(50), email varchar(50),direccion varchar(50))");
        sqLiteDatabase.execSQL("create table datosEmergencia(telefonoContacto1 varchar(50) primary key not null, nombreContacto1 varchar(50), telefonoContacto2 varchar(50) , nombreContacto2 varchar(50), telefonoContacto3 varchar(50) , nombreContacto3 varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
