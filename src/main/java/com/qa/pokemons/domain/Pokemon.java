package com.qa.pokemons.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class Pokemon {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private Long id;
		
		@Column
		private String name;
		
		@Column
		private String colour;
		
		@Column
		private Long power;
		
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
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
		
		public  Long getPower() {
			return power;
		}
		
		public void setPower(Long power) {
			this.power = power;
		}
	
		public Pokemon() {
			
		}
		
		public Pokemon(String name, String colour,
				 Long power) {
			
		}
		
		public Pokemon(Long id, String name, String colour,
				 Long power) {
			
			this.id = id;
			this.name = name;
			this.colour = colour;
			this.power = power;
		}

		
		@Override
		public int hashCode() {
			return Objects.hash(colour, id, name, power);
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
			return Objects.equals(colour, other.colour) && Objects.equals(id, other.id)
					&& Objects.equals(name, other.name) && Objects.equals(power, other.power);
		}

		@Override
		public String toString() {
			return "Pokemon [id=" + id + ", name=" + name + ", colour=" + colour + ", power=" + power + "]";
		}

		
		
		
		
}
