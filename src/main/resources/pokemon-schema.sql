CREATE DATABASE IF NOT EXISTS pokemonDB;

DROP TABLE IF EXISTS pokemon CASCADE;
CREATE TABLE 'pokemon' (
	id BIGINT AUTO_INCREMENT, 
	'name' VARCHAR(50) NOT NULL,
	'colour' VARCHAR(50),
	'power' SMALLINT(3) NOT NULL,
	PRIMARY KEY ('id')
	);