package com.ayandas.pokemonrest.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pokemon")
@Entity
@Table(name = "Pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int ndex;
    private String forme;
    private String species;
    private String type1;
    private String type2;
    private String ability1;
    private String ability2;
    private String abilityH;
    private int hp;
    private int attack;
    private int defense;
    private int spattack;
    private int spdefense;
    private int speed;
    private String eggGroup1;
    private String eggGroup2;

    public Pokemon() {}

    public Pokemon(int id, int ndex, String forme, String species, String type1, String type2,
        String ability1, String ability2, String abilityH, int hp, int attack,
        int defense, int spattack, int spdefense, int speed, String eggGroup1,
        String eggGroup2) {
        this.id = id;
        this.ndex = ndex;
        this.forme = forme;
        this.species = species;
        this.type1 = type1;
        this.type2 = type2;
        this.ability1 = ability1;
        this.ability2 = ability2;
        this.abilityH = abilityH;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spdefense = spdefense;
        this.speed = speed;
        this.eggGroup1 = eggGroup1;
        this.eggGroup2 = eggGroup2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNdex() {
        return ndex;
    }

    public void setNdex(int ndex) {
        this.ndex = ndex;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getForme() {
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getAbility1() {
        return ability1;
    }

    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }

    public String getAbility2() {
        return ability2;
    }

    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }

    public String getAbilityH() {
        return abilityH;
    }

    public void setAbilityH(String abilityH) {
        this.abilityH = abilityH;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpattack() {
        return spattack;
    }

    public void setSpattack(int spattack) {
        this.spattack = spattack;
    }

    public int getSpdefense() {
        return spdefense;
    }

    public void setSpdefense(int spdefense) {
        this.spdefense = spdefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getEggGroup1() {
        return eggGroup1;
    }

    public void setEggGroup1(String eggGroup1) {
        this.eggGroup1 = eggGroup1;
    }

    public String getEggGroup2() {
        return eggGroup2;
    }

    public void setEggGroup2(String eggGroup2) {
        this.eggGroup2 = eggGroup2;
    }

    public String toString() {
        String line1 = species + "\n";
        String line2 = type1 + "/" + type2 + "\n";
        String line3 = "HP: " + hp + "\n";
        String line4 = "Attack: " + attack + "\n";
        String line5 = "Defense: " + defense  + "\n";
        String line6 = "Special Attack: " + spattack  + "\n";
        String line7 = "Special Defense: " + spdefense  + "\n";
        String line8 = "Speed: " + speed  + "\n";
        String line9 = "Forme: " + forme;
        return line1 + line2 + line3 + line4 + line5 + line6 + line7 + line8
            + line9;
    }
}
