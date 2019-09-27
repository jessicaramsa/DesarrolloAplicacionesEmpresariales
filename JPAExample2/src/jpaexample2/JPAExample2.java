/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexample2;

import controladoras.AlumnoJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jessi
 */
public class JPAExample2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExample2PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
    }
    
    public void crearAlumno(EntityManagerFactory emf, Alumno alumno) {
        //Alumno a = new Alumno(1, "Ramirez", "Jessica", 7, 0);
        //Alumno a = new Alumno(2, "Zapata", "Jorge", 9, 1);
        
        try {
            new AlumnoJpaController(emf).create(alumno);
            System.out.println("Alumno creado");
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
    public void consultarAlumno(EntityManagerFactory emf, int id) {
        try {
            Alumno a = new AlumnoJpaController(emf).findAlumno(id);
            System.out.println(a.toString());
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
    public void eliminarEliminar(EntityManagerFactory emf, int id) {
        try {
            new AlumnoJpaController(emf).destroy(id);
            System.out.println("Alumno eliminado");
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
    public void editarAlumno(EntityManagerFactory emf, Alumno alumno) {
        alumno = new AlumnoJpaController(emf).findAlumno(4);
        alumno.setNombre("Nombre editado");
        
        try {
            new AlumnoJpaController(emf).edit(alumno);
            System.out.println("Editado");
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}