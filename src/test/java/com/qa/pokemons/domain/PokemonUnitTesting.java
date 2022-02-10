package com.qa.pokemons.domain;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class PokemonUnitTesting {
	
	@Test
	public void testConstructorWithId() {
		Pokemon pokemon = new Pokemon(1, "Bob", "Blue", 999);
	
	assertNotNull(pokemon.getPokemonId());
	assertNotNull(pokemon.getName());
	assertNotNull(pokemon.getColour());
	assertNotNull(pokemon.getPower());
	
	
	assertEquals(1, pokemon.getPokemonId());
	assertEquals("Bob", pokemon.getName());
	assertEquals("Blue", pokemon.getColour());
	assertEquals(999, pokemon.getPower());
	
	}
	
	@Test
	public void testToString() {
		Pokemon pokemon = new Pokemon(1, "Bob", "Blue", 999);
		
		assertEquals("Pokemon [pokemonId=1, name=Bob, colour=Blue, power=999]", pokemon.toString());
	}
}
