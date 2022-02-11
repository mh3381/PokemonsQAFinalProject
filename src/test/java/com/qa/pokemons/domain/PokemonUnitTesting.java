package com.qa.pokemons.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PokemonUnitTesting {
	
	private Pokemon newPokemon;
	
	@BeforeEach
	public void setUp() {
		newPokemon = new Pokemon(1L, "Bob", "Blue", 999L);
	}
    

    @Test
    public void testConstructorName() {
        assertEquals("Bob", newPokemon.getName());
    }

    @Test
    public void testToString() {
    	Pokemon newPokemon = new Pokemon();
        assertEquals(newPokemon.toString(),"Pokemon[id=0, name=null, colour=null, power=0]");
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Pokemon.class).usingGetClass().withPrefabValues(Pokemon.class, newPokemon, new Pokemon()).withNonnullFields("id").verify();

    }
}
