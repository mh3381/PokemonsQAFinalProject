package com.qa.pokemons.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pokemons.domain.Pokemon;



@SpringBootTest	
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:pokemon-schema.sql","classpath:pokemon-data.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PokemonControllerTest {
	
	 	@Autowired
	    private MockMvc mock;

	    @Autowired
	    private ObjectMapper map;
	    
	    private Pokemon schemaPokemon;
	    private Pokemon createPokemon;
	    private Pokemon getPokemon;
	    private Pokemon updatePokemon;
	    
	    @BeforeEach
	    public void setUp() {
	    	schemaPokemon = new Pokemon(1L, "Jackie", "Pink", 777L);
	    	createPokemon = new Pokemon("Jackie", "Pink", 777L);
	    	getPokemon = new Pokemon(2L, "Jackie", "Pink", 777L);
	    	updatePokemon = new Pokemon(1L, "Francis", "Magenta", 884L);
	    }
	    
	    @Test 
	    void testCreateCont() throws Exception {
	   
	    	String newPokemonJSON = this.map.writeValueAsString(createPokemon);
	    	RequestBuilder mockRequest = post("/pokemon").contentType(MediaType.APPLICATION_JSON).content(newPokemonJSON);
	    	String savedPokemonJSON = this.map.writeValueAsString(getPokemon);
	    	
	    	ResultMatcher matchStatus = status().isAccepted();
	    	ResultMatcher matchBody = content().json(savedPokemonJSON);
	    	
	    	this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	    	System.out.println(newPokemonJSON);
	    	System.out.println(savedPokemonJSON);
	    }
	    
	    @Test
	    void testReadAll() throws Exception {
	        List<Pokemon> allPokemons = List.of(schemaPokemon);
	        String allPokemonsJSON = this.map.writeValueAsString(allPokemons);
	        RequestBuilder readReq = get("/pokemon");

	        ResultMatcher matchStatus = status().isAccepted();
	        ResultMatcher matchBody = content().json(allPokemonsJSON);

	        this.mock.perform(readReq).andExpect(matchStatus).andExpect(matchBody);
}
	    
	    @Test
	    void testReadOne() throws Exception {
	        String schemaPokemonJSON = this.map.writeValueAsString(schemaPokemon);
	        RequestBuilder readReq = get("/pokemon" + schemaPokemon.getId());

	        ResultMatcher matchStatus = status().isAccepted();
	        ResultMatcher matchBody = content().json(schemaPokemonJSON);

	        this.mock.perform(readReq).andExpect(matchStatus).andExpect(matchBody);
	    }
	    
	    @Test
	    void testUpdate() throws Exception {
	        String updatePokemonJSON = this.map.writeValueAsString(updatePokemon);
	        RequestBuilder updateReq = put("/pokemon" + schemaPokemon.getId()).contentType(MediaType.APPLICATION_JSON).content(updatePokemonJSON);

	        ResultMatcher matchStatus = status().isAccepted();
	        ResultMatcher matchBody = content().json(updatePokemonJSON);

	        this.mock.perform(updateReq).andExpect(matchStatus).andExpect(matchBody);
	    }
	    
	    @Test
	    void testDelete() throws Exception {
	        String schemaPokemonJSON = this.map.writeValueAsString(schemaPokemon);
	        RequestBuilder updateReq = delete("/pokemon" + schemaPokemon.getId());

	        ResultMatcher matchStatus = status().isAccepted();
	        ResultMatcher matchBody = content().json(schemaPokemonJSON);

	        this.mock.perform(updateReq).andExpect(matchStatus).andExpect(matchBody);
}

}











































