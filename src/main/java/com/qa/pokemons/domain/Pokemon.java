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
		
		public String getType() {
			return type;
		}
		
		public void setType(String type) {
			this.type = type;
		}
		
		public int getDamage() {
			return damage;
		}
		
		public void setDamage(int damage) {
			this.damage = damage;
		}
		
		public boolean isMagical() {
			return magical;
		}
		
		public void setMagical(boolean magical) {
			this.magical = magical;
}
}
