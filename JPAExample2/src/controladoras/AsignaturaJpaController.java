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
import jpaexample2.AlumnoAsignatura;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpaexample2.Asignatura;

/**
 *
 * @author jessi
 */
public class AsignaturaJpaController implements Serializable {

    public AsignaturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Asignatura asignatura) throws PreexistingEntityException, Exception {
        if (asignatura.getAlumnoAsignaturaCollection() == null) {
            asignatura.setAlumnoAsignaturaCollection(new ArrayList<AlumnoAsignatura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<AlumnoAsignatura> attachedAlumnoAsignaturaCollection = new ArrayList<AlumnoAsignatura>();
            for (AlumnoAsignatura alumnoAsignaturaCollectionAlumnoAsignaturaToAttach : asignatura.getAlumnoAsignaturaCollection()) {
                alumnoAsignaturaCollectionAlumnoAsignaturaToAttach = em.getReference(alumnoAsignaturaCollectionAlumnoAsignaturaToAttach.getClass(), alumnoAsignaturaCollectionAlumnoAsignaturaToAttach.getAlumnoAsignaturaPK());
                attachedAlumnoAsignaturaCollection.add(alumnoAsignaturaCollectionAlumnoAsignaturaToAttach);
            }
            asignatura.setAlumnoAsignaturaCollection(attachedAlumnoAsignaturaCollection);
            em.persist(asignatura);
            for (AlumnoAsignatura alumnoAsignaturaCollectionAlumnoAsignatura : asignatura.getAlumnoAsignaturaCollection()) {
                Asignatura oldAsignaturaOfAlumnoAsignaturaCollectionAlumnoAsignatura = alumnoAsignaturaCollectionAlumnoAsignatura.getAsignatura();
                alumnoAsignaturaCollectionAlumnoAsignatura.setAsignatura(asignatura);
                alumnoAsignaturaCollectionAlumnoAsignatura = em.merge(alumnoAsignaturaCollectionAlumnoAsignatura);
                if (oldAsignaturaOfAlumnoAsignaturaCollectionAlumnoAsignatura != null) {
                    oldAsignaturaOfAlumnoAsignaturaCollectionAlumnoAsignatura.getAlumnoAsignaturaCollection().remove(alumnoAsignaturaCollectionAlumnoAsignatura);
                    oldAsignaturaOfAlumnoAsignaturaCollectionAlumnoAsignatura = em.merge(oldAsignaturaOfAlumnoAsignaturaCollectionAlumnoAsignatura);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAsignatura(asignatura.getIdAsignatura()) != null) {
                throw new PreexistingEntityException("Asignatura " + asignatura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Asignatura asignatura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asignatura persistentAsignatura = em.find(Asignatura.class, asignatura.getIdAsignatura());
            Collection<AlumnoAsignatura> alumnoAsignaturaCollectionOld = persistentAsignatura.getAlumnoAsignaturaCollection();
            Collection<AlumnoAsignatura> alumnoAsignaturaCollectionNew = asignatura.getAlumnoAsignaturaCollection();
            List<String> illegalOrphanMessages = null;
            for (AlumnoAsignatura alumnoAsignaturaCollectionOldAlumnoAsignatura : alumnoAsignaturaCollectionOld) {
                if (!alumnoAsignaturaCollectionNew.contains(alumnoAsignaturaCollectionOldAlumnoAsignatura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AlumnoAsignatura " + alumnoAsignaturaCollectionOldAlumnoAsignatura + " since its asignatura field is not nullable.");
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
            asignatura.setAlumnoAsignaturaCollection(alumnoAsignaturaCollectionNew);
            asignatura = em.merge(asignatura);
            for (AlumnoAsignatura alumnoAsignaturaCollectionNewAlumnoAsignatura : alumnoAsignaturaCollectionNew) {
                if (!alumnoAsignaturaCollectionOld.contains(alumnoAsignaturaCollectionNewAlumnoAsignatura)) {
                    Asignatura oldAsignaturaOfAlumnoAsignaturaCollectionNewAlumnoAsignatura = alumnoAsignaturaCollectionNewAlumnoAsignatura.getAsignatura();
                    alumnoAsignaturaCollectionNewAlumnoAsignatura.setAsignatura(asignatura);
                    alumnoAsignaturaCollectionNewAlumnoAsignatura = em.merge(alumnoAsignaturaCollectionNewAlumnoAsignatura);
                    if (oldAsignaturaOfAlumnoAsignaturaCollectionNewAlumnoAsignatura != null && !oldAsignaturaOfAlumnoAsignaturaCollectionNewAlumnoAsignatura.equals(asignatura)) {
                        oldAsignaturaOfAlumnoAsignaturaCollectionNewAlumnoAsignatura.getAlumnoAsignaturaCollection().remove(alumnoAsignaturaCollectionNewAlumnoAsignatura);
                        oldAsignaturaOfAlumnoAsignaturaCollectionNewAlumnoAsignatura = em.merge(oldAsignaturaOfAlumnoAsignaturaCollectionNewAlumnoAsignatura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = asignatura.getIdAsignatura();
                if (findAsignatura(id) == null) {
                    throw new NonexistentEntityException("The asignatura with id " + id + " no longer exists.");
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
            Asignatura asignatura;
            try {
                asignatura = em.getReference(Asignatura.class, id);
                asignatura.getIdAsignatura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asignatura with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<AlumnoAsignatura> alumnoAsignaturaCollectionOrphanCheck = asignatura.getAlumnoAsignaturaCollection();
            for (AlumnoAsignatura alumnoAsignaturaCollectionOrphanCheckAlumnoAsignatura : alumnoAsignaturaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asignatura (" + asignatura + ") cannot be destroyed since the AlumnoAsignatura " + alumnoAsignaturaCollectionOrphanCheckAlumnoAsignatura + " in its alumnoAsignaturaCollection field has a non-nullable asignatura field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(asignatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Asignatura> findAsignaturaEntities() {
        return findAsignaturaEntities(true, -1, -1);
    }

    public List<Asignatura> findAsignaturaEntities(int maxResults, int firstResult) {
        return findAsignaturaEntities(false, maxResults, firstResult);
    }

    private List<Asignatura> findAsignaturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Asignatura.class));
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

    public Asignatura findAsignatura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Asignatura.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsignaturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Asignatura> rt = cq.from(Asignatura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
