DROP SCHEMA IF EXISTS biblioteca;
DROP USER IF exists 'biblioteca_user'@'%';

CREATE SCHEMA biblioteca;
create user 'biblioteca_user'@'%' identified by 'Dp123456';
grant all privileges on biblioteca.* to 'biblioteca_user'@'%';
flush privileges;

USE biblioteca;

/*
* luego de crear el usuario y asignarlo no debiera de ejecutarse nuevamente
*/


CREATE TABLE libros (
idLibro int NOT NULL AUTO_INCREMENT,
  id VARCHAR(10)  NOT NULL,
  titulo VARCHAR(50) NOT NULL,
  editorial VARCHAR(30) NOT NULL,
  year int unsigned NOT NULL,
  version int unsigned NOT NULL,
  author VARCHAR(30) NOT NULL,
  tematica VARCHAR(30) NOT NULL,
  PRIMARY KEY (idLibro)
  
);

insert into libros (id,titulo,editorial,year,version,author,tematica) values 
('001','Intro al Calculo','Patito', '2020', '2', 'Karl Marx', 'Matematicas'),
('002','Recetas facileso','Patito', '2021', '2', 'Tia Florinda', 'Cocina'),
('003','Primer Programa','Hails', '2020', '4', 'Hitler', 'Ingenieria');

CREATE TABLE usuario (
idUsuario int NOT NULL AUTO_INCREMENT,
emailUsuario VARCHAR(50) NOT NULL,
  pwUsuario varchar(255) not null,
  nombreUsuario VARCHAR(50) NOT NULL,
  apellidosUsuario VARCHAR(50) NOT NULL,
  provinciaUsuario varchar(30) not null,
  cantonUsuario varchar(30) not null,
  activo Boolean,
  idRol VARCHAR(15) NOT NULL,
  PRIMARY KEY (idUsuario)
);