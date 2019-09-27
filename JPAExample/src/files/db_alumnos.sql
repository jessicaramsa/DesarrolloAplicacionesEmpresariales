CREATE DATABASE db_alumnos;
USE db_alumnos;
CREATE TABLE alumno (
    id_alumno int not null primary key,
    apellidos varchar(40) NOT NULL,
    nombre varchar(30) NOT NULL,
    curso int,
    titulacion int
);

CREATE TABLE asignatura (
    id_asignatura int NOT NULL PRIMARY KEY,
    tipo varchar(2) NOT NULL,
    nombre varchar(60) NOT NULL,
    creditos float
);

CREATE TABLE alumno_asignatura (
    id_alumno int NOT NULL,
    id_asignatura int NOT NULL,
    cursada char(1),
    FOREIGN KEY(id_alumno) REFERENCES alumno(id_alumno),
    FOREIGN KEY(id_asignatura) REFERENCES asignatura(id_asignatura),
    PRIMARY KEY(id_alumno, id_asignatura)
);