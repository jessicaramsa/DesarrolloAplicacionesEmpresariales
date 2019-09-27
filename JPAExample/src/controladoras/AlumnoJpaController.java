/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoras;

import controladoras.exceptions.IllegalOrphanException;
import controladoras.exceptions.NonexistentEntityException;
import controladoras.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpaexample.AlumnoAsignatura;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpaexample.Alumno;

/**
 *
 * @author jessi
 */
public class AlumnoJpaController implements Serializable {

    public AlumnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alumno alumno) throws PreexistingEntityException, Exception {
        if (alumno.getAlumnoAsignaturaCollection() == null) {
            alumno.setAlumnoAsignaturaCollection(new ArrayList<AlumnoAsignatura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<AlumnoAsignatura> attachedAlumnoAsignaturaCollection = new ArrayList<AlumnoAsignatura>();
            for (AlumnoAsignatura alumnoAsignaturaCollectionAlumnoAsignaturaToAttach : alumno.getAlumnoAsignaturaCollection()) {
                alumnoAsignaturaCollectionAlumnoAsignaturaToAttach = em.getReference(alumnoAsignaturaCollectionAlumnoAsignaturaToAttach.getClass(), alumnoAsignaturaCollectionAlumnoAsignaturaToAttach.getAlumnoAsignaturaPK());
                attachedAlumnoAsignaturaCollection.add(alumnoAsignaturaCollectionAlumnoAsignaturaToAttach);
            }
            alumno.setAlumnoAsignaturaCollection(attachedAlumnoAsignaturaCollection);
            em.persist(alumno);
            for (AlumnoAsignatura alumnoAsignaturaCollectionAlumnoAsignatura : alumno.getAlumnoAsignaturaCollection()) {
                Alumno oldAlumnoOfAlumnoAsignaturaCollectionAlumnoAsignatura = alumnoAsignaturaCollectionAlumnoAsignatura.getAlumno();
                alumnoAsignaturaCollectionAlumnoAsignatura.setAlumno(alumno);
                alumnoAsignaturaCollectionAlumnoAsignatura = em.merge(alumnoAsignaturaCollectionAlumnoAsignatura);
                if (oldAlumnoOfAlumnoAsignaturaCollectionAlumnoAsignatura != null) {
                    oldAlumnoOfAlumnoAsignaturaCollectionAlumnoAsignatura.getAlumnoAsignaturaCollection().remove(alumnoAsignaturaCollectionAlumnoAsignatura);
                    oldAlumnoOfAlumnoAsignaturaCollectionAlumnoAsignatura = em.merge(oldAlumnoOfAlumnoAsignaturaCollectionAlumnoAsignatura);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlumno(alumno.getIdAlumno()) != null) {
                throw new PreexistingEntityException("Alumno " + alumno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alumno alumno) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno persistentAlumno = em.find(Alumno.class, alumno.getIdAlumno());
            Collection<AlumnoAsignatura> alumnoAsignaturaCollectionOld = persistentAlumno.getAlumnoAsignaturaCollection();
            Collection<AlumnoAsignatura> alumnoAsignaturaCollectionNew = alumno.getAlumnoAsignaturaCollection();
            List<String> illegalOrphanMessages = null;
            for (AlumnoAsignatura alumnoAsignaturaCollectionOldAlumnoAsignatura : alumnoAsignaturaCollectionOld) {
                if (!alumnoAsignaturaCollectionNew.contains(alumnoAsignaturaCollectionOldAlumnoAsignatura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AlumnoAsignatura " + alumnoAsignaturaCollectionOldAlumnoAsignatura + " since its alumno field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<AlumnoAsignatura> attachedAlumnoAsignaturaCollectionNew = new ArrayList<AlumnoAsignatura>();
            for (AlumnoAsignatura alumnoAsignaturaCollectionNewAlumnoAsignaturaToAttach : alumnoAsignaturaCollectionNew) {
                alumnoAsignaturaCollectionNewAlumnoAsignaturaToAttach = em.getReference(alumnoAsignaturaCollectionNewAlumnoAsignaturaToAttach.getClass(), alumnoAsignaturaCollectionNewAlumnoAsignaturaToAttach.getAlumnoAsignaturaPK());
                attachedAlumnoAsignaturaCollectionNew.add(alumnoAsignaturaCollectionNewAlumnoAsignaturaToAttach);
            }
            alumnoAsignaturaCollectionNew = attachedAlumnoAsignaturaCollectionNew;
            alumno.setAlumnoAsignaturaCollection(alumnoAsignaturaCollectionNew);
            alumno = em.merge(alumno);
            for (AlumnoAsignatura alumnoAsignaturaCollectionNewAlumnoAsignatura : alumnoAsignaturaCollectionNew) {
                if (!alumnoAsignaturaCollectionOld.contains(alumnoAsignaturaCollectionNewAlumnoAsignatura)) {
                    Alumno oldAlumnoOfAlumnoAsignaturaCollectionNewAlumnoAsignatura = alumnoAsignaturaCollectionNewAlumnoAsignatura.getAlumno();
                    alumnoAsignaturaCollectionNewAlumnoAsignatura.setAlumno(alumno);
                    alumnoAsignaturaCollectionNewAlumnoAsignatura = em.merge(alumnoAsignaturaCollectionNewAlumnoAsignatura);
                    if (oldAlumnoOfAlumnoAsignaturaCollectionNewAlumnoAsignatura != null && !oldAlumnoOfAlumnoAsignaturaCollectionNewAlumnoAsignatura.equals(alumno)) {
                        oldAlumnoOfAlumnoAsignaturaCollectionNewAlumnoAsignatura.getAlumnoAsignaturaCollection().remove(alumnoAsignaturaCollectionNewAlumnoAsignatura);
                        oldAlumnoOfAlumnoAsignaturaCollectionNewAlumnoAsignatura = em.merge(oldAlumnoOfAlumnoAsignaturaCollectionNewAlumnoAsignatura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alumno.getIdAlumno();
                if (findAlumno(id) == null) {
                    throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno alumno;
            try {
                alumno = em.getReference(Alumno.class, id);
                alumno.getIdAlumno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<AlumnoAsignatura> alumnoAsignaturaCollectionOrphanCheck = alumno.getAlumnoAsignaturaCollection();
            for (AlumnoAsignatura alumnoAsignaturaCollectionOrphanCheckAlumnoAsignatura : alumnoAsignaturaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Alumno (" + alumno + ") cannot be destroyed since the AlumnoAsignatura " + alumnoAsignaturaCollectionOrphanCheckAlumnoAsignatura + " in its alumnoAsignaturaCollection field has a non-nullable alumno field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(alumno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alumno> findAlumnoEntities() {
        return findAlumnoEntities(true, -1, -1);
    }

    public List<Alumno> findAlumnoEntities(int maxResults, int firstResult) {
        return findAlumnoEntities(false, maxResults, firstResult);
    }

    private List<Alumno> findAlumnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Alumno findAlumno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumno.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumno> rt = cq.from(Alumno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
