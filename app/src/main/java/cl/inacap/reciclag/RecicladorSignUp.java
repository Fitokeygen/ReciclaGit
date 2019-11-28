package cl.inacap.reciclag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecicladorSignUp extends AppCompatActivity {
    private Toolbar toolbar;
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    Button mButtonRegister;
    DatabaseHelper bdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclador_sign_up);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ingresar");

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_solicitudes", null, 1);

        bdd = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.correoRecTxt);
        mTextPassword = (EditText)findViewById(R.id.contraseñaRecTxt);
        mButtonLogin = (Button)findViewById(R.id.button_login);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registroIntent = new Intent(RecicladorSignUp.this, Registrarse.class);
                startActivity(registroIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = bdd.checkUser(user, pwd);
                if (res == true){
                    Intent loggea2 = new Intent(RecicladorSignUp.this,AddSolicitud.class);
                    startActivity(loggea2);
                }
                else{
                    Toast.makeText(RecicladorSignUp.this, "Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

/*
    public void entrarBoton(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.ingresarRecBtn:
                miIntent=new Intent(RecicladorSignUp.this,AddSolicitud.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }

 */
}
