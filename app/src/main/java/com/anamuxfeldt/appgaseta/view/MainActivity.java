package com.anamuxfeldt.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.anamuxfeldt.appgaseta.R;
import com.anamuxfeldt.appgaseta.apoio.UtilGasEta;

public class MainActivity extends AppCompatActivity {

   // public static final int TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        Toast.makeText(MainActivity.this,UtilGasEta.calcularMelhorOpcao(5.12, 3.39),
                Toast.LENGTH_LONG).show();
        //comutarTela();
    }

   /* private void comutarTela() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent telaPrincipal = new Intent(MainActivity.this,
                        GasEtaActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT);
    }*/
}