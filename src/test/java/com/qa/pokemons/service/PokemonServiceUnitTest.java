package com.qa.pokemons.service;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.pokemons.domain.Pokemon;
import com.qa.pokemons.repo.PokemonRepo;

@SpringBootTest
public class PokemonServiceUnitTest {
	
	@Autowired
	private PokemonService service;
	
	@MockBean
	private PokemonRepo repo;
	
	// CREATE TEST
	@Test
	public void createTest() {
		Pokemon testInput = new Pokemon(1, "Bob", "Blue", 999);
		Pokemon mockInput = new Pokemon(1, "Bob", "Blue", 999);
		
		// CREATE TEST
		Mockito.when(this.service.create(testInput)).thenReturn(mockInput);
		
		assertEquals(mockInput, this.service.create(testInput));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(testInput);
	}
	
	//READ ALL
	@Test
	public void readAllTest() {
		List<Pokemon> mockInput = new ArrayList<Pokemon>();
		
		mockInput.add(new Pokemon(1, "Bob", "Blue", 999));
		
		Mockito.when(this.repo.findAll()).thenReturn(mockInput);
		assertEquals(mockInput, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	//READ
	
	@Test
	public void readPokemonById() {
		
		int validId = 5;
		int invalidId = 222;
		
		Pokemon testInput = new Pokemon(1, "Bob", "Blue", 999);
		Pokemon mockInput = new Pokemon(1, "Bob", "Blue", 999);

		Optional<Pokemon> validPokemon = Optional.ofNullable(new Pokemon(1, "Bob", "Blue", 999));
				
		Mockito.when(this.repo.findById(validId)).thenReturn(validPokemon);
		
		assertEquals(validPokemon.get(), this.service.readById(validId));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(validId);
	
}
}