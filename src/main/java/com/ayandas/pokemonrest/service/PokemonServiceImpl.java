package com.ayandas.pokemonrest.service;

import com.ayandas.pokemonrest.dbops.DBUtil;
import com.ayandas.pokemonrest.models.Pokemon;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pokemon")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PokemonServiceImpl implements PokemonService {

    @Override
    @GET
    @Path("/{id}")
    public Pokemon getPokemon(@PathParam("id") int id) {
        Pokemon p = null;
        try {
            p = DBUtil.getPokemon(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (p == null) {
                p = new Pokemon();
                p.setForme("No Pokemon exists with this ID");
                p.setSpecies("No Pokemon exists with this ID");
                p.setType1("No Pokemon exists with this ID");
                p.setType2("No Pokemon exists with this ID");
                p.setAbility1("No Pokemon exists with this ID");
                p.setAbility2("No Pokemon exists with this ID");
                p.setAbilityH("No Pokemon exists with this ID");
                p.setEggGroup1("No Pokemon exists with this ID");
                p.setEggGroup2("No Pokemon exists with this ID");
            }
            return p;
        }
    }

    @Override
    @GET
    @Path("/formes/{id}")
    public Pokemon[] getPokemonFormes(@PathParam("id") int id) {
        List<Pokemon> pokemon = new ArrayList<>();
        try {
            pokemon = DBUtil.getPokemonFormes(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pokemon.size() == 0) {
                return new Pokemon[0];
            } else {
                Pokemon[] result = pokemon.toArray(new Pokemon[pokemon.size()]);
                return result;
            }
        }
    }

    @Override
    @GET
    @Path("/")
    public Pokemon[] getAllPokemon() {
        List<Pokemon> pokemon = new ArrayList<>();
        try {
            pokemon = DBUtil.allPokemon();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pokemon.size() == 0) {
                return new Pokemon[0];
            } else {
                Pokemon[] result = pokemon.toArray(new Pokemon[pokemon.size()]);
                return result;
            }
        }
    }

}
