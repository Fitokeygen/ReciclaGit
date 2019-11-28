package cl.inacap.reciclag;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Biennial extends AppCompatActivity {

    private Button loginReciclador;
    private Button loginConductor;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Recicla-G");


        loginReciclador = (Button) findViewById(R.id.recicloBtn);
        loginConductor = (Button) findViewById(R.id.conduzcoBtn);

        loginReciclador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterRecicladorIntent = new Intent(Biennial.this, RecicladorSignUp.class);
                startActivity(LoginRegisterRecicladorIntent);
            }
        });

        loginConductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterConductorIntent = new Intent(Biennial.this, ConductorSignUp2.class);
                startActivity(LoginRegisterConductorIntent);
            }
        });
    }
}
