package com.anamuxfeldt.appgaseta.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anamuxfeldt.appgaseta.R;
import com.anamuxfeldt.appgaseta.database.GasEtaDB;

public class SplashActivity extends AppCompatActivity {

public static final int TIME_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comutarTelaSplash();
    }

    private void comutarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                GasEtaDB db = new GasEtaDB(SplashActivity.this);

                Intent telaMain = new Intent(
                        SplashActivity.this, MainActivity.class);
                startActivity(telaMain);
                finish();
            }
        }, TIME_OUT_SPLASH);
    }

}
