package com.qa.pokemons.service;


import static org.junit.Assert.assertEquals;

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
	
	
	@Test
	public void createTest() {
		Pokemon testInput = new Pokemon(1, "Bob", "Blue", 999);
		Pokemon mockInput = new Pokemon(1, "Bob", "Blue", 999);
		
		Mockito.when(this.service.create(testInput)).thenReturn(mockInput);
		
		assertEquals(mockInput, this.service.create(testInput));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(testInput);
	}

}
