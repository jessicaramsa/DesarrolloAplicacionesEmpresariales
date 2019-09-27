CREATE DATABASE db_alumnosdos;
USE db_alumnosdos;
CREATE TABLE alumnos (
	id_alumno INT PRIMARY KEY NOT NULL,
    apellidos VARCHAR(24),
    nombre VARCHAR(18),
    curso INT,
    titulacion INT
);

CREATE TABLE asignaturas (
	id_asignatura INT PRIMARY KEY NOT NULL,
    tipo VARCHAR(2),
    nombre VARCHAR(60),
    creditos FLOAT
);

CREATE TABLE alumnos_asignaturas (
	id_alumno INT NOT NULL,
    id_asignatura INT NOT NULL,
    cursada CHAR(2),
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id_alumno) ON DELETE CASCADE,
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas(id_asignatura) ON DELETE CASCADE,
    PRIMARY KEY(id_alumno, id_asignatura)
);
