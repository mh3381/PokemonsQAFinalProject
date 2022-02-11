package com.qa.pokemons.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qa.pokemons.domain.Pokemon;
import com.qa.pokemons.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        super();
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pokemon> add(@RequestBody Pokemon pokemon) {
        this.service.create(pokemon);
        return new ResponseEntity<Pokemon>(pokemon, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List> readAll() {
        return new ResponseEntity<List>(this.service.readAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<Pokemon>(this.service.getById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updateById(@PathVariable("id") Long id, @RequestBody Pokemon pokemon) {
        return new ResponseEntity<Pokemon>(this.service.updateById(id, pokemon), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pokemon> deleteById(@PathVariable("id") Long id) {
        return new ResponseEntity<Pokemon>(this.service.deleteById(id), HttpStatus.ACCEPTED);
    }

}