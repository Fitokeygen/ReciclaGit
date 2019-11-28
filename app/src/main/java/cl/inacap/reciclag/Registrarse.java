package cl.inacap.reciclag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity {

    DatabaseHelper bdd;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextConPassword;
    Button mButtonLogin;
    Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        bdd = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.correoRecTxt);
        mTextPassword = (EditText)findViewById(R.id.contraseñaRecTxt);
        mTextConPassword = (EditText)findViewById(R.id.con_contraseñaRecTxt);
        mButtonRegister = (Button)findViewById(R.id.button_registrarse);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextConPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = bdd.addUser(user,pwd);
                    if (val > 0) {
                        Toast.makeText(Registrarse.this, "Registrado correctamente",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(Registrarse.this,RecicladorSignUp.class);
                        startActivity(moveToLogin);
                    }else{
                        Toast.makeText(Registrarse.this, "Error en registro",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(Registrarse.this, "Contraseña no coincide",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
