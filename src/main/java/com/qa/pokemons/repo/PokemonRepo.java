package com.qa.pokemons.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.qa.pokemons.domain.Pokemon;

@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Integer> {

}
