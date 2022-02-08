package com.qa.pokemons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Domain {
@Getter
@Setter
@AllArgsConstructor
@Entity	
@Table(name = "pokemon")
			public class Pokemon {
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column
			private int pokemonId;
			
			@Column
			@NotNull(message = "Name must be entered")
			private String name;
			
			@Column
			private String colour;
			
			@Min(1)
			@Max(999)
			@Column
			private int power;
			
			@Column
			private String type;
			
			@Column
			private int damage;
			
			@Column
			private boolean magical;
}
		
}
