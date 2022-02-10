package com.qa.pokemons.service;

import java.util.List;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.pokemons.domain.Pokemon;
import com.qa.pokemons.repo.PokemonRepo;

@Service
public class PokemonService implements CRUDServiceInterface<Pokemon>  {
	
	private PokemonRepo repo;
	
	public PokemonService(PokemonRepo repo) {
		this.repo = repo;
		
	}
		
	@Override
	public Pokemon create(Pokemon pokemon) {
		return this.repo.save(pokemon);
		
	}

	@Override
	public List<Pokemon> readAll() {
		 return this.repo.findAll();
	}

	@Override
	public Pokemon readById(int pokemonId) {
		Optional<Pokemon> optionalPokemon = this.repo.findById(pokemonId);
        return optionalPokemon.get();
		
	}

	@Override
	public Pokemon update(int pokemonId, Pokemon updatedPokemon) {
		 Optional<Pokemon> optionalPokemon = this.repo.findById(pokemonId);
	        if (optionalPokemon.isPresent()) {
	            Pokemon existingPokemon = optionalPokemon.get();
	            existingPokemon.setPokemonId(updatedPokemon.getPokemonId());
	            existingPokemon.setName(updatedPokemon.getName());
	            existingPokemon.setColour(updatedPokemon.getColour());
	            existingPokemon.setPower(updatedPokemon.getPower());
	            return existingPokemon;
	        }
		return null;
	}

	@Override
	public boolean delete(int pokemonId) {
		boolean deleted = false;
	      Optional<Pokemon> optionalPokemon = this.repo.findById(pokemonId);
	      if (optionalPokemon.isPresent()) {
	          this.repo.deleteById(pokemonId);
	          deleted = true;
	          return deleted;
	       }
	       return deleted;
	}

}
