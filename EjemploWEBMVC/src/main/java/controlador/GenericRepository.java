/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author kp215
 */
public class GenericRepository <EntityType>{
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public GenericRepository() {
        emf = Persistence.createEntityManagerFactory("jessicaramsa_EjemploWEBMVC_war_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    public void create(EntityType entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(entity);
            transaction.commit();
        } catch(Exception ex) {
            if(transaction.isActive())
                transaction.rollback();
            throw ex;
        }
    }
    
    public void update(EntityType entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(entity);
            transaction.commit();
        } catch(Exception ex) {
            if(transaction.isActive())
                transaction.rollback();
            throw ex;
        }
    }
    
    public void delete(EntityType entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(entity);
            transaction.commit();
        } catch(Exception ex) {
            if(transaction.isActive())
                transaction.rollback();
            throw ex;
        }
    }
    
    public EntityType getById(Class<EntityType> entityClass, Object id) {
        EntityTransaction transaction = em.getTransaction();
        EntityType foundEntity;
        transaction.begin();
        try {
            foundEntity = em.find(entityClass, id);
            transaction.commit();
            return foundEntity;
        } catch(Exception ex) {
            if(transaction.isActive())
                transaction.rollback();
            throw ex;
        }
    }
    
    
    public List<EntityType> getList(String entityName) {
        return em.createQuery("SELECT e FROM " + entityName + " e").getResultList();
    }
    
    public List<EntityType> search(String query) {
        
        System.out.println("Consulta ejecutada: " + query);
        return em.createQuery(query).getResultList();
    }
    
    public EntityManager entityGetEntityManager() {
        return this.em;
    }
}

