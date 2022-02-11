package com.qa.pokemons.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.qa.pokemons.domain.Pokemon;
import com.qa.pokemons.repo.PokemonRepo;

@Service
public class PokemonService implements CRUDServiceInterface<Pokemon>  {
	
	 private final PokemonRepo repo;

	    public PokemonService(PokemonRepo repo) {
	        super();
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
	    public Pokemon getById(Long id) {
	        return this.repo.findById(id).orElseThrow();
	    }

	    @Override
	    public Pokemon updateById(Long id, Pokemon pokemon) {
	        Pokemon oldItem = this.repo.findById(id).orElseThrow();
	        oldItem.setName(pokemon.getName());
	        oldItem.setColour(pokemon.getColour());
	        oldItem.setPower(pokemon.getPower());
	        
	        return this.repo.save(oldItem);
	    }

	    @Override
	    public Pokemon deleteById(Long id) {
	        Pokemon deletedItem = this.repo.findById(id).orElseThrow();
	        this.repo.deleteById(id);
	        return deletedItem;
	    }

		
	
		

}
