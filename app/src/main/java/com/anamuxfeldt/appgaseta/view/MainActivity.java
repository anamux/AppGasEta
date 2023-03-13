package com.anamuxfeldt.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anamuxfeldt.appgaseta.R;
import com.anamuxfeldt.appgaseta.apoio.UtilGasEta;

public class MainActivity extends AppCompatActivity {
    EditText txtGasolina, txtEtanol;
    Button btnCalcular, btnLimpar, btnSalvar,btnFinalizar;
    TextView txtResultado;

    double precoEtanol, precoGasolina;
    String recomendacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        txtGasolina = findViewById(R.id.txtGasolina);
        txtEtanol = findViewById(R.id.txtEtanol);
        txtResultado = findViewById(R.id.txtResultado);


        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOk = true;

                if(TextUtils.isEmpty(txtGasolina.getText())){
                    txtGasolina.setError("Obrigatório digitar o valor da Gasolina...");
                    txtGasolina.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(txtEtanol.getText())){
                    txtEtanol.setError("Obrigatório digitar o valor da Etanol...");
                    txtEtanol.requestFocus();
                    isDadosOk = false;
                }
                if(isDadosOk){
                    precoGasolina = Double.parseDouble(txtGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(txtEtanol.getText().toString());

                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol);

                    txtResultado.setText(recomendacao);

                }else{
                    Toast.makeText(MainActivity.this, "Digite os dados obrigatórios.", Toast.LENGTH_SHORT).show();
                }


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

                txtEtanol.setText("");
                txtGasolina.setText("");
                txtResultado.setText("RESULTADO");

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