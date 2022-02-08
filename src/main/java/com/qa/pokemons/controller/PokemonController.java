package com.qa.pokemons.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.pokemons.domain.Pokemon;
import com.qa.pokemons.service.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
	private PokemonService service;
	public List<Pokemon> creatures = new ArrayList<Pokemon>();
	
	public PokemonController(PokemonService service, List<Pokemon> creatures) {
        this.service = service;
        this.creatures = creatures;
	}
	
	public PokemonController() {
		
	}
@PostMapping("/createpokemon")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        creatures.add(pokemon);
        return new ResponseEntity<Pokemon>(this.service.create(pokemon), HttpStatus.CREATED);
    }
@GetMapping("/getById/{pokemonId}")
    public ResponseEntity<?> getPlayer(@PathVariable Optional<Integer> pokemonId){
        if(pokemonId.isPresent()){
            return new ResponseEntity<Pokemon>(creatures.get(pokemonId.get()), HttpStatus.FOUND);

        }else {
            return new ResponseEntity<List<Pokemon>>(creatures, HttpStatus.NOT_FOUND);
        }

    
    }  
@PutMapping("/updateById/{pokemonId}")
    public ResponseEntity<?> putPokemon(@PathVariable int pokemonId, @RequestBody Pokemon pokemon) {
        return new ResponseEntity<Pokemon>(this.service.update(pokemonId, pokemon), HttpStatus.OK);
    }  
@DeleteMapping("/deleteById/{pokemonId}") 
    public ResponseEntity<Boolean> deletePokemon(@PathVariable int pokemonId) {
        boolean deleted = this.service.delete(pokemonId);
        return (deleted) ? new ResponseEntity<Boolean>(deleted, HttpStatus.OK)
            : new ResponseEntity<Boolean>(deleted, HttpStatus.NOT_FOUND);
    }
}
