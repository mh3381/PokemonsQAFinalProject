drop table if exists `pokemon` CASCADE;

create table pokemon (
pokemon_id integer not null auto_increment, 
colour varchar(255), 
name varchar(255), 
power integer, 
primary key (pokemon_id)
);