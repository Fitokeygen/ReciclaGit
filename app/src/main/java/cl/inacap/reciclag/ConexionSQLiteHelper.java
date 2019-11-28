package cl.inacap.reciclag;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import cl.inacap.reciclag.utils.Utils;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {



    //creacion de constructor, se le llama para crear la base de datos
    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//generar las tablas de nuestros objetos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utils.CREAR_TABLA_SOLICITUD);
    }


//cada vez que instalamos la app, verificará si existe una version antigua, y actuara segun lo que programemos.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS solicitudes");
        onCreate(db);
    }
}
