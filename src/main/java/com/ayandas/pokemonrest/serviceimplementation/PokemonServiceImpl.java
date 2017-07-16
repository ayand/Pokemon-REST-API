package com.ayandas.pokemonrest.serviceimplementation;

import com.ayandas.pokemonrest.dbops.DBPokemonUtil;
import com.ayandas.pokemonrest.models.GenericResponse;
import com.ayandas.pokemonrest.models.Pokemon;
import com.ayandas.pokemonrest.service.PokemonService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

public class PokemonServiceImpl implements PokemonService {

    @Override
    public Response getPokemon(int id) {
        Pokemon p = null;
        try {
            p = DBPokemonUtil.getPokemon(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (p == null) {
                GenericResponse g = new GenericResponse();
                g.setMessage("No Pokemon exists with this ID");
                return Response.status(404).entity(g).build();
            }
            return Response.status(200).entity(p).build();
        }
    }

    @Override
    public Response getPokemonFormes(int id) {
        List<Pokemon> pokemon = new ArrayList<>();
        try {
            pokemon = DBPokemonUtil.getPokemonFormes(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pokemon.size() == 0) {
                GenericResponse g = new GenericResponse();
                g.setMessage("No Pokemon exists with this ID");
                return Response.status(404).entity(g).build();
            }
            return Response.status(200).entity(pokemon).build();
        }
    }

    @Override
    public Response getAllPokemon() {
        List<Pokemon> pokemon = new ArrayList<>();
        try {
            pokemon = DBPokemonUtil.allPokemon();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pokemon.size() == 0) {
                GenericResponse g = new GenericResponse();
                g.setMessage("The list of Pokemon could not be retrieved for some reason");
                return Response.status(400).entity(g).build();
            }
            return Response.status(200).entity(pokemon).build();
        }
    }

    @Override
    public Response getStrongerOpponents(int id) {
      List<Pokemon> pokemon = new ArrayList<>();
      try {
          pokemon = DBPokemonUtil.getStrongerOpponents(id);
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          if (pokemon.size() == 0) {
              GenericResponse g = new GenericResponse();
              g.setMessage("No Pokemon exists with this ID");
              return Response.status(404).entity(g).build();
          }
          return Response.status(200).entity(pokemon).build();
      }
    }

}
