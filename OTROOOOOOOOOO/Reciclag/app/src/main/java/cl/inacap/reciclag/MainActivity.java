package cl.inacap.reciclag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent bienvenidoIntent = new Intent(MainActivity.this, Biennial.class);
                    startActivity(bienvenidoIntent);
                }

            }
        };
        thread.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
