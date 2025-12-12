package org.example.service;

import org.example.model.Adestrador;
import org.example.model.Pokemon;
import org.example.repository.AdestradorRepository;
import org.example.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepo;
    private final AdestradorRepository adestradorRepo;

    public PokemonService(PokemonRepository pokemonRepository, AdestradorRepository adestradorRepository){
        this.pokemonRepo = pokemonRepository;
        this.adestradorRepo = adestradorRepository;
    }

    public void crearPokemon(Pokemon p){
        pokemonRepo.save(p);
    }

    public Pokemon buscarPokemon(String id){
        return pokemonRepo.findById(id).orElse(null);
    }

    public List<Pokemon> buscarPokemones(){
        return pokemonRepo.findAll();
    }

    public Adestrador buscarAdestradorDelPokemon(String idPokemon){
        Pokemon pokemon = buscarPokemon(idPokemon);
        if (pokemon == null) return null;

        Adestrador adestrador = adestradorRepo.findById(pokemon.getAdestradorId()).orElse(null);

        return adestrador;
    }

}
