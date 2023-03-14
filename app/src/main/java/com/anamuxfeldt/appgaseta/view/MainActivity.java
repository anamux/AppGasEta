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
import com.anamuxfeldt.appgaseta.controller.CombustivelController;
import com.anamuxfeldt.appgaseta.model.Combustivel;

public class MainActivity extends AppCompatActivity {
    CombustivelController combustivelController;
    Combustivel combustivelGasolina, combustivelEtanol;
    EditText txtGasolina, txtEtanol;
    Button btnCalcular, btnLimpar, btnSalvar, btnFinalizar;
    TextView txtResultado;

    double precoEtanol, precoGasolina;
    String recomendacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        combustivelController = new CombustivelController(MainActivity.this);

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

                if (TextUtils.isEmpty(txtGasolina.getText())) {
                    txtGasolina.setError("Obrigatório digitar o valor da Gasolina...");
                    txtGasolina.requestFocus();
                    isDadosOk = false;
                }
                if (TextUtils.isEmpty(txtEtanol.getText())) {
                    txtEtanol.setError("Obrigatório digitar o valor da Etanol...");
                    txtEtanol.requestFocus();
                    isDadosOk = false;
                }
                if (isDadosOk) {
                    precoGasolina = Double.parseDouble(txtGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(txtEtanol.getText().toString());

                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(recomendacao);

                    btnSalvar.setEnabled(true);

                } else {
                    Toast.makeText(MainActivity.this, "Digite os dados obrigatórios.", Toast.LENGTH_SHORT).show();
                    btnSalvar.setEnabled(false);
                }


            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                combustivelController.salvar(combustivelGasolina);
                combustivelController.salvar(combustivelEtanol);
                int parada = 0;

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtEtanol.setText("");
                txtGasolina.setText("");
                txtResultado.setText("RESULTADO");

                btnSalvar.setEnabled(false);

                combustivelController.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Toast.makeText(MainActivity.this, UtilGasEta.calcularMelhorOpcao(5.12, 3.39),
                Toast.LENGTH_LONG).show();

    }


}