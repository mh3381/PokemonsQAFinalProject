package com.qa.pokemons;

import java.util.ArrayList;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qa.pokemons.domain.Pokemon;

@SpringBootApplication
public class PokemonsApplication {
	
	@Bean
	public List<Pokemon> makeListBean() {
		List<Pokemon> pokemon = new ArrayList<>();
		pokemon.add(new Pokemon(0, "Mayiev", "Orange", 998));
		return pokemon;
	}

	public static void main(String[] args) {
		SpringApplication.run(PokemonsApplication.class, args);
	}

}
