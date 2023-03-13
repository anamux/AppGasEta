package com.anamuxfeldt.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anamuxfeldt.appgaseta.R;
import com.anamuxfeldt.appgaseta.apoio.UtilGasEta;

public class MainActivity extends AppCompatActivity {
    EditText txtGasolina, txtAlcool;
    Button btnCalcular, btnLimpar, btnSalvar,btnFinalizar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        txtGasolina = findViewById(R.id.txtGasolina);
        txtAlcool = findViewById(R.id.txtAlcool);
        txtResultado = findViewById(R.id.txtResultado);


        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });





        Toast.makeText(MainActivity.this,UtilGasEta.calcularMelhorOpcao(5.12, 3.39),
                Toast.LENGTH_LONG).show();

    }


}