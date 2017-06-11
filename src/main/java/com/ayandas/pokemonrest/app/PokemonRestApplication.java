package com.ayandas.pokemonrest.app;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import com.ayandas.pokemonrest.serviceimplementation.PokemonServiceImpl;

public class PokemonRestApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public PokemonRestApplication() {
        singletons.add(new PokemonServiceImpl());
    }

    @Override
	   public Set<Object> getSingletons() {
		     return singletons;
	   }

}
