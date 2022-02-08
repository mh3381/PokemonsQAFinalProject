package com.qa.pokemons.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
		
		
		public int getPokemonId() {
			return pokemonId;
		}
		
		public void setPokemonId(int pokemonId) {
			this.pokemonId = pokemonId;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getColour() {
			return colour;
		}
		
		public void setColour(String colour) {
			this.colour = colour;
		}
		
		public int getPower() {
			return power;
		}
		
		public void setPower(int power) {
			this.power = power;
		}
	
		public Pokemon() {
			
		}
		
		public Pokemon(int pokemonId, String name, String colour,
				 int power) {
			
			this.pokemonId = pokemonId;
			this.name = name;
			this.colour = colour;
			this.power = power;
		}

		@Override
		public int hashCode() {
			return Objects.hash(colour, name, pokemonId, power);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pokemon other = (Pokemon) obj;
			return Objects.equals(colour, other.colour) && Objects.equals(name, other.name)
					&& pokemonId == other.pokemonId && power == other.power;
		}
		
		
}
