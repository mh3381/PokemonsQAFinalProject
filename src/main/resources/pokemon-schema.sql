drop table if exists `pokemon` CASCADE;

create table pokemon (
id BIGINT not null AUTO_INCREMENT, 
colour varchar(255), 
name varchar(255), 
power BIGINT, 
primary key (id)
);