/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

/**
 *
 * @author ruben
 */
import entidadesJPA.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersonaDAO implements IPersonaDAO {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public PersonaDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPU"); 
        entityManager = emf.createEntityManager(); // Inicializar entityManager
    }

    @Override
    public void guardarPersona(Persona persona) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(persona); // Guardar la persona en la base de datos
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e; // Re-lanzar la excepción para que el llamador pueda manejarla
        } finally {
            em.close();
        }
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return entityManager.find(Persona.class, id);
    }

    public boolean existePersonaConRFC(String rfc) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            // Consulta para verificar si existe una persona con el RFC dado
            Query query = entityManager.createQuery("SELECT COUNT(p) FROM Persona p WHERE p.RFC = :rfc");
            query.setParameter("rfc", rfc);
            Long count = (Long) query.getSingleResult();
            return count > 0;
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void actualizarPersona(Persona persona) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(persona); // Actualizar la persona en la base de datos
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e; // Re-lanzar la excepción para que el llamador pueda manejarla
        }
    }

    @Override
    public void eliminarPersona(Long id) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            Persona persona = entityManager.find(Persona.class, id);
            if (persona != null) {
                entityManager.remove(persona); // Eliminar la persona de la base de datos
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e; // Re-lanzar la excepción para que el llamador pueda manejarla
        }
    }
}
