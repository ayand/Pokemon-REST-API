package com.ayandas.pokemonrest.service;

import com.ayandas.pokemonrest.models.Pokemon;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import com.ayandas.pokemonrest.models.Matchup;

@Path("/pokemon")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PokemonService {

    @GET
    @Path("/{id}")
    public Response getPokemon(@PathParam("id") int id);

    @GET
    @Path("/formes/{id}")
    public Response getPokemonFormes(@PathParam("id") int id);

    @GET
    @Path("/")
    public Response getAllPokemon();

    @GET
    @Path("/strongerOpponents/{id}")
    public Response getStrongerOpponents(@PathParam("id") int id);
}
