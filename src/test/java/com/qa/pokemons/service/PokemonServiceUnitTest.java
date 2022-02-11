package com.qa.pokemons.service;


import static org.assertj.core.api.Assertions.assertThat;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.pokemons.domain.Pokemon;
import com.qa.pokemons.repo.PokemonRepo;

@SpringBootTest
@ActiveProfiles("test")
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
	//READ BY ID
	
	@Test
	public void readByIdTest() {
		
		int validId = 5;
		int invalidId = 222;
		
		Pokemon testInput = new Pokemon(1, "Bob", "Blue", 999);
		Pokemon mockInput = new Pokemon(1, "Bob", "Blue", 999);

		Optional<Pokemon> validPokemon = Optional.ofNullable(new Pokemon(1, "Bob", "Blue", 999));
				
		Mockito.when(this.repo.findById(validId)).thenReturn(validPokemon);
		
		assertEquals(validPokemon.get(), this.service.readById(validId));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(validId);
	
	}
	
	
	//UPDATE
	
	@Test
	public void updateTest() {
		
		int id = 1;
		
		Pokemon toUpdate = new Pokemon(1, "Bob", "Blue", 999);
		Optional<Pokemon> optPokemon = Optional.of(new Pokemon(id, null, null, 0));
		Pokemon updated = new Pokemon(toUpdate.getPokemonId(), toUpdate.getName(), toUpdate.getColour(), toUpdate.getPower());
		
		Mockito.when(this.repo.findById(id)).thenReturn(optPokemon);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		
		assertThat(this.service.update(id, toUpdate)).isEqualTo(updated);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

	}
	//DELETE BY ID
	@Test
	public void deleteByIdTest() {
		
		int invalidId = 66;
		
		Mockito.when(this.repo.existsById(invalidId)).thenReturn(false);
		
		assertEquals(true, this.service.delete(invalidId));
		
		Mockito.verify(this.repo).deleteById(invalidId);
		
	}
}
	
	