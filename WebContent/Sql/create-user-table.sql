CREATE DATABASE bruno_db;
USE bruno_db;

create table autos (
	id  int(3) NOT NULL AUTO_INCREMENT,
	modelo varchar(120) NOT NULL,
	color varchar(220) NOT NULL,
	marca varchar(120),
	PRIMARY KEY (id)
);

