package cl.inacap.reciclag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.reciclag.objetos.Solicitud;
import cl.inacap.reciclag.utils.Utils;

public class mostrarSolicitudes extends AppCompatActivity {

    ListView listViewSolicitudes;
    ArrayList<String> listaInfo;
    ArrayList<Solicitud> listaSolicitudes;

    ConexionSQLiteHelper conn;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_solicitudes);
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mostrar Solicitudes");

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_solicitudes",null,1);

        listViewSolicitudes= (ListView) findViewById(R.id.listViewSolicitudes);

        consultarListaSolicitudes();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInfo);
        listViewSolicitudes.setAdapter(adaptador);

        listViewSolicitudes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long l) {
                String info="nombre: "+listaSolicitudes.get(pos).getNombre()+"\n";
                info+="lotes: "+listaSolicitudes.get(pos).getLotes()+"\n";
                info+="direccion: "+listaSolicitudes.get(pos).getDireccion()+"\n";

                Toast.makeText(getApplicationContext(),info,Toast.LENGTH_LONG).show();

                Solicitud solic=listaSolicitudes.get(pos);

                Intent intent=new Intent(mostrarSolicitudes.this,detalleSolicitud.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("solicitud",solic);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

    private void consultarListaSolicitudes() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Solicitud solicitud=null;
        listaSolicitudes=new ArrayList<Solicitud>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utils.TABLA_SOLICITUDES,null);

        while (cursor.moveToNext()){
            solicitud=new Solicitud();
            solicitud.setNombre(cursor.getString(0));
            solicitud.setLotes(cursor.getInt(1));
            solicitud.setDireccion(cursor.getString(2));

            listaSolicitudes.add(solicitud);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInfo=new ArrayList<String>();

        for(int i=0; i<listaSolicitudes.size();i++){
            listaInfo.add(listaSolicitudes.get(i).getNombre());
        }
    }
}
