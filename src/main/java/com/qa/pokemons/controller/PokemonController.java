package com.qa.pokemons.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.pokemons.domain.Pokemon;


@RestController
public class PokemonController {
	
	private List<Pokemon> pokemon = new ArrayList<>();
	

	@PostMapping("/createPokemon")
	public void createPokemon(@RequestBody Pokemon p) {
		this.pokemon.add(p);
	}
	
	@GetMapping("/getPokemon")
	public List<Pokemon> getPokemon(){
		return this.pokemon;
	}

	@GetMapping("/getOne/{id}")
	public Pokemon getOne(@PathVariable int id) {
		return this.pokemon.get(id);
	}

	@PutMapping("/updatePokemon/{id}")
	public Pokemon updatePokemon(@PathVariable int id, @RequestBody Pokemon p) {
		this.pokemon.remove(id);
		this.pokemon.add(id, p);
		return this.pokemon.get(id);
	}
	

	@DeleteMapping("/deletePokemon/{id}")
	public Pokemon removePokemon(@PathVariable int id) {
		return this.pokemon.remove(id);
	}
}