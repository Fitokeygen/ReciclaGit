package cl.inacap.reciclag;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Biennial extends AppCompatActivity {

    private Button loginReciclador;
    private Button loginConductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

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
