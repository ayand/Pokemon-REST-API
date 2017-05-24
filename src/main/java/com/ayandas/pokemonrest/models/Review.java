package com.ayandas.pokemonrest.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "review")
@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userID;
    private int pokemonID;
    private String review;

    public Review() {}

    public Review(int id, int userID, int pokemonID, String review) {
        this.id = id;
        this.userID = userID;
        this.pokemonID = pokemonID;
        this.review = review;
    }

    public Review(int userID, int pokemonID, String review) {
        this.userID = userID;
        this.pokemonID = pokemonID;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String toString() {
        String line1 = "User ID: " + userID + ", Pokemon ID: " + pokemonID + "\n";
        return line1 + review;
    }
}
