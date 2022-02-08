package com.qa.pokemons.service;

import java.util.List;

public interface CRUDServiceInterface<T> {
	
	T create(T t);

    List<T> readAll();

    T readById(int pokemonId);

    T update(int pokemonId, T t);

    boolean delete(int pokemon);
}
