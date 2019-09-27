/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexample;

import controladoras.AlumnoJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jessi
 */
public class TestControladoras {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExamplePU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        
        Alumno a = new Alumno(20, "Ramirez", "Jessica", 7, 0);
        
        try {
            new AlumnoJpaController(emf).create(a);
            System.out.println("Alumno creado");
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
