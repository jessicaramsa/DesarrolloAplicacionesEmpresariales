/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jessi
 */
public class JPAExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExamplePU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        
        // Insercion
        //Alumno alumno;
        //Alumno alumno = new Alumno(5, "", "Probando", 1, 0);

        // Consultar un alumno
        Alumno alumno = em.find(Alumno.class, 1);
        //alumno.setNombre("Jessica");
        alumno.setApellidos("Ramirez");
        
        tx.begin();
        try {
            em.persist(alumno);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        
        /*//Eliminar alumno
        Alumno alumno = em.find(Alumno.class, 2);
        
        tx.begin();
        try {
            if (alumno != null) {
                em.remove(alumno);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }*/
        /*
        // otras instrucciones
        tx.begin();
        try {
            Alumno alumno = em.find(Alumno.class, 2);
            if (alumno != null) {
                em.remove(alumno);
            }
            em.flush(); //toda la transaccion
            em.refresh(alumno); //similar al rollback, una sola entidad
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }*/
    }
}
