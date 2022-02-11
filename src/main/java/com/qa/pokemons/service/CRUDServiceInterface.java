package com.qa.pokemons.service;

import java.util.List;

public interface CRUDServiceInterface<T> {
	
	T create(T t);

    List<T> readAll();

    T getById(Long id);

    T updateById(Long id, T t);

    T  deleteById(Long id);
}
