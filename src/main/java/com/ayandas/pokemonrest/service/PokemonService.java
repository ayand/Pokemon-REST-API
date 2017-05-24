package com.ayandas.pokemonrest.service;

import com.ayandas.pokemonrest.models.Pokemon;
//import com.ayandas.pokemonrest.models.Matchup;

public interface PokemonService {
    public Pokemon getPokemon(int id);

    public Pokemon[] getPokemonFormes(int id);

    public Pokemon[] getAllPokemon();
}
