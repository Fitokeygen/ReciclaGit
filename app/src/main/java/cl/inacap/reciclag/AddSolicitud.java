package cl.inacap.reciclag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.inacap.reciclag.utils.Utils;


public class AddSolicitud extends AppCompatActivity {

    EditText nombreRecTxt, lotesRectTxt, direccionRecTxt;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_solicitud);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Reciclar");

        nombreRecTxt= (EditText) findViewById(R.id.nombreRecTxt);
        lotesRectTxt= (EditText) findViewById(R.id.lotesRectTxt);
        direccionRecTxt= (EditText) findViewById(R.id.direccionRecTxt);
    }


    public void eventoBoton(View view) {
        agregarSolicitudes();
    }

    private void agregarSolicitudes() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_solicitudes", null, 1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utils.CAMPO_NOMBRE,nombreRecTxt.getText().toString());
        values.put(Utils.CAMPO_LOTES,lotesRectTxt.getText().toString());
        values.put(Utils.CAMPO_DIRECCION,direccionRecTxt.getText().toString());

        Long idResultado=db.insert(Utils.TABLA_SOLICITUDES,Utils.CAMPO_NOMBRE,values);

        Toast.makeText(getApplicationContext(),"Reciclaje n°: "+idResultado,Toast.LENGTH_SHORT).show();
        db.close();

    }
}
