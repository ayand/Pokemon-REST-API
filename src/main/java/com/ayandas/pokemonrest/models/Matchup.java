package com.ayandas.pokemonrest.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "matchup")
@Entity
@Table(name = "TypeChart")
public class Matchup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String defenseType1;
    private String defenseType2;
    private String attackType;
    private double effect;

    public Matchup() {}

    public Matchup(int id, String defenseType1, String defenseType2,
        String attackType, double effect) {
        this.id = id;
        this.defenseType1 = defenseType1;
        this.defenseType2 = defenseType2;
        this.attackType = attackType;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDefenseType1() {
        return defenseType1;
    }

    public void setDefenseType1(String defenseType1) {
        this.defenseType1 = defenseType1;
    }

    public String getDefenseType2() {
        return defenseType2;
    }

    public void setDefenseType2(String defenseType2) {
        this.defenseType2 = defenseType2;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public double getEffect() {
        return effect;
    }

    public void setEffect(double effect) {
        this.effect = effect;
    }

    public String toString() {
        if (defenseType2.equals("")) {
            String result = defenseType1 + " vs " + attackType + ": " + effect + "x";
            return result;
        } else {
            String result = defenseType1 + "/" + defenseType2 + " vs " + attackType + ": " + effect + "x";
            return result;
        }
    }
}
