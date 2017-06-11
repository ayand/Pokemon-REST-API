package com.ayandas.pokemonrest.extrapojo;

public class Type {
    private String typeName;
    private double effect;

    public Type() {}

    public Type(String typeName, double effect) {
        this.typeName = typeName;
        this.effect = effect;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getEffect() {
        return effect;
    }

    public void setEffect(double effect) {
        this.effect = effect;
    }
}
