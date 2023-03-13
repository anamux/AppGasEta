package com.anamuxfeldt.appgaseta.model;

public class Combustivel {

    private String nomeDoCombustivel;
    private double precoDoCombustivel;
    private String recomendação;

    public String getNomeDoCombustivel() {
        return nomeDoCombustivel;
    }

    public void setNomeDoCombustivel(String nomeDoCombustivel) {
        this.nomeDoCombustivel = nomeDoCombustivel;
    }

    public double getPrecoDoCombustivel() {
        return precoDoCombustivel;
    }

    public void setPrecoDoCombustivel(double precoDoCombustivel) {
        this.precoDoCombustivel = precoDoCombustivel;
    }

    public String getRecomendação() {
        return recomendação;
    }

    public void setRecomendação(String recomendação) {
        this.recomendação = recomendação;
    }
}
