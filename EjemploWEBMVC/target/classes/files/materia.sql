create database materias;
use materias;

create table materias(
  ID int auto_increment primary key,
  nombre varchar(100) not null,
  semestre int not null
);

insert into materias(nombre, semestre) values('Calculo Diferencial', 1);
insert into materias(nombre, semestre) values('Taller de Etica', 1);
insert into materias(nombre, semestre) values('Taller de administracion', 1);

insert into materias(nombre, semestre) values('Calculo Integral', 2);
insert into materias(nombre, semestre) values('Probabilidad y estadistica', 2);
insert into materias(nombre, semestre) values('Algebra lineal', 2);

insert into materias(nombre, semestre) values('Investigacion de operaciones', 3);
insert into materias(nombre, semestre) values('Fisica', 3);
insert into materias(nombre, semestre) values('Desarrollo Sustentable', 3);

insert into materias(nombre, semestre) values('Topicos Avanzados de programacion', 4);
insert into materias(nombre, semestre) values('Simulacion', 4);
insert into materias(nombre, semestre) values('Fundamentos de Base de Datos', 4);

insert into materias(nombre, semestre) values('Fundamentos de Ingenieria de Software', 5);
insert into materias(nombre, semestre) values('Fundamento de Telecomunicaciones', 5);
insert into materias(nombre, semestre) values('Taller de base de datos', 5);

insert into materias(nombre, semestre) values('Lenguaje y automatas 1', 6);
insert into materias(nombre, semestre) values('Administracion de base de datos', 6);
insert into materias(nombre, semestre) values('Ingenieria de Software', 6);

insert into materias(nombre, semestre) values('Lenguaje y automatas 2', 7);
insert into materias(nombre, semestre) values('Taller de investigacion 1', 7);
insert into materias(nombre, semestre) values('Sistemas Programables', 7);

insert into materias(nombre, semestre) values('Taller de investigacion 2', 8);
insert into materias(nombre, semestre) values('Programacion Logica y Funcional', 8);
insert into materias(nombre, semestre) values('Administracion de Redes', 8);

insert into materias(nombre, semestre) values('Inteligencia Artificial', 9);
insert into materias(nombre, semestre) values('Residencias Profesionales', 9);