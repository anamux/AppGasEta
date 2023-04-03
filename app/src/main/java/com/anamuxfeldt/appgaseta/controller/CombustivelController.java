package com.anamuxfeldt.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import com.anamuxfeldt.appgaseta.database.GasEtaDB;
import com.anamuxfeldt.appgaseta.model.Combustivel;
import com.anamuxfeldt.appgaseta.view.MainActivity;

import java.util.List;

public class CombustivelController extends GasEtaDB {
    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";
    public CombustivelController(MainActivity activity){
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);

        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel objCombustivel){

        ContentValues dados = new ContentValues();
        dadosPreferences.putString("combustivel", objCombustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("preco", (float) objCombustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendação", objCombustivel.getRecomendacao());
        dadosPreferences.apply();

        dados.put("nomeDoCombustivel", objCombustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", objCombustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", objCombustivel.getRecomendacao());
        salvarObjeto("Combustivel", dados);
    }

    public List<Combustivel> getListaDeDados(){
        return listarDados();
    }

    public void alterar(Combustivel objCombustivel){

        ContentValues dados = new ContentValues();
        dados.put("id", objCombustivel.getId());
        dados.put("nomeDoCombustivel", objCombustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", objCombustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", objCombustivel.getRecomendacao());
        salvarObjeto("Combustivel", dados);

        alterarObjeto("Combustivel", dados);

    }
    public void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }

    public void deletarObjeto(int id){

        deletarObjeto("Combustivel", id);

    }

}
