package com.qa.pokemons.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	
	private Pokemon newPokemon;
	private Pokemon savedPokemon;
	
	@InjectMocks
	private PokemonService service;
	
	@Mock
	private PokemonRepo repo;
	
	@BeforeEach
	public void setUp() {
		newPokemon = new Pokemon(1L,"Jackie", "Magenta", 884L);
		savedPokemon = new Pokemon(1L, "Jackie", "Magenta", 884L);
		
	}
	
	@Test
	public void testAdd() {
		Mockito.when(this.repo.save(newPokemon)).thenReturn(savedPokemon);
        assertEquals(savedPokemon, this.service.create(newPokemon));
        Mockito.verify(this.repo, Mockito.times(1)).save(newPokemon);
    }

    @Test
    public void testGetAll() {
        Mockito.when(this.repo.findAll()).thenReturn(List.of(savedPokemon));
        assertEquals(List.of(savedPokemon), this.service.readAll());
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Mockito.when(this.repo.findById(savedPokemon.getId())).thenReturn(Optional.ofNullable(savedPokemon));
        assertEquals(savedPokemon, this.service.getById(savedPokemon.getId()));
        Mockito.verify(this.repo, Mockito.times(1)).findById(savedPokemon.getId());
    }

    @Test
    public void updateById() {
        Mockito.when(this.repo.findById(savedPokemon.getId())).thenReturn(Optional.ofNullable(savedPokemon));
        Mockito.when(this.repo.save(newPokemon)).thenReturn(savedPokemon);
        assertEquals(savedPokemon, this.service.updateById(savedPokemon.getId(), newPokemon));
        Mockito.verify(this.repo, Mockito.times(1)).findById(savedPokemon.getId());
        Mockito.verify(this.repo, Mockito.times(1)).save(newPokemon);
    }

    @Test
    public void deleteById() {
        Mockito.when(this.repo.findById(savedPokemon.getId())).thenReturn(Optional.ofNullable(savedPokemon));
        assertEquals(savedPokemon, this.service.deleteById(savedPokemon.getId()));
        Mockito.verify(this.repo, Mockito.times(1)).findById(savedPokemon.getId());
    }
	
}
	