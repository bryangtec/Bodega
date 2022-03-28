package com.example.bodega;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DaoUsuario {
    Context c;
    Usuarios u;
    ArrayList<Usuarios> lista;
    SQLiteDatabase sql;
    String bd = "bdUsuarios";
    String tabla = "Create Table usuario(id integer primary key autoincrement, usuario text, pass text, nombre text, apellido text)";

    public DaoUsuario(Context c) {
       this.c=c;
       sql = c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
       sql.execSQL(tabla);
       u = new Usuarios();
    }
    public boolean insertUsuario(Usuarios u){
        if (buscar(u.getUsuario())==0){
            ContentValues cv = new ContentValues();
            cv.put("usuario",u.getUsuario());
            cv.put("pass",u.getPassword());
            cv.put("nombre",u.getNombre());
            cv.put("apellido",u.getApellidos());
            return (sql.insert("usuario", null, cv)>0);
        }else{
            return false;
        }
    }

    public int buscar (String u){
        int x = 0;
        lista = selectUsuarios();
        for (Usuarios us:lista) {
            if (us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuarios> selectUsuarios(){
        Cursor cr = sql.rawQuery("select * from usuarios",null);
        if (cr!= null&&cr.moveToFirst()){
            do {
                Usuarios u = new Usuarios();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellidos(cr.getString(4));
            }while (cr.moveToNext());
        }return lista;
    }
}
