package com.qa.pokemons.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	
	@Test
	void testCreateCont() throws Exception {
		
		Pokemon newP = new Pokemon("JACK", "PINK", 400);
		String newPJSON = this.map.writeValueAsString(newP);		
		RequestBuilder mockRequest = post("/createPokemon").contentType(MediaType.APPLICATION_JSON).content(newPJSON);		
		Pokemon savedP = new Pokemon(2, "JACK", "PINK", 400);		
		String savedPJSON = this.map.writeValueAsString(savedP);		
		ResultMatcher matchStatus = status().isCreated();		
		ResultMatcher matchBody = content().json(savedPJSON);		
	}
	

	@Test
	void testReadAllPokemon() throws Exception {
		
		Pokemon newP = new Pokemon("JACK", "PINK", 400);
		String newPJSON = this.map.writeValueAsString(newP);		
		RequestBuilder mockRequest = get("/getPokemon").contentType(MediaType.APPLICATION_JSON).content(newPJSON);		
		ResultMatcher matchStatus = status().isFound();			
		ResultMatcher matchBody = content().json(newPJSON);		
		
	}
	 @Test
	 void testReadByIdPokemon() throws Exception {
		 Pokemon newP = new Pokemon(1, "JACK", "PINK", 400);
			String newPJSON = this.map.writeValueAsString(newP);		
			RequestBuilder mockRequest = get("/getOne/id").contentType(MediaType.APPLICATION_JSON).content(newPJSON);		
			ResultMatcher matchStatus = status().isFound();			
			ResultMatcher matchBody = content().json(newPJSON);		
			
	 }
	
	
	@Test
	void testUpdateCont() throws Exception {
		
		Pokemon newP = new Pokemon(1, "JACK", "PINK", 400);
		String newPJSON = this.map.writeValueAsString(newP);
		RequestBuilder mockRequest = put("/updateById").contentType(MediaType.APPLICATION_JSON).content(newPJSON);
		Pokemon savedP = new Pokemon("JACK", "PINK", 400);
		String savedPJSON = this.map.writeValueAsString(savedP);
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(newPJSON);
		
		
	}
	
	@Test
	void testDeleteCont() throws Exception {
		
		Pokemon delP = new Pokemon(1, "JACK", "PINK", 400);
		String delPJSON = this.map.writeValueAsString(delP);
		RequestBuilder mockRequest = delete("/deleteById").contentType(MediaType.APPLICATION_JSON).content(delPJSON);
		
		Pokemon savedP = new Pokemon(1, "JACK", "PINK", 400);
		String savedPJSON = this.map.writeValueAsString(savedP);
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(delPJSON);
	}
}
