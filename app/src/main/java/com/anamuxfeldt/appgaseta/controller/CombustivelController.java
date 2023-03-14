package com.anamuxfeldt.appgaseta.controller;

import android.content.SharedPreferences;

import com.anamuxfeldt.appgaseta.model.Combustivel;
import com.anamuxfeldt.appgaseta.view.MainActivity;

public class CombustivelController {
    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";
    public CombustivelController(MainActivity activity){
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);

        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel objCombustivel){
        dadosPreferences.putString("combustivel", objCombustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("preco", (float) objCombustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendação", objCombustivel.getRecomendacao());
        dadosPreferences.apply();
    }
    public void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
