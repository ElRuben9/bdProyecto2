/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

/**
 *
 * @author ruben
 */
import entidadesJPA.Automovil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class AutomovilDAO implements IAutomovilDAO {

    private EntityManagerFactory emf;

    public AutomovilDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
    }

    @Override
    public void guardarAutomovil(Automovil automovil) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // Asignar fechas de emisión y recepción
            automovil.setFechaEmision(new Date());
            automovil.setFechaRecepcion(null);
            em.persist(automovil);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void actualizarAutomovil(Automovil automovil) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(automovil);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Automovil obtenerAutomovilPorNumeroSerie(String numeroSerie) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT a FROM Automovil a WHERE a.numeroSerie = :numeroSerie");
            query.setParameter("numeroSerie", numeroSerie);
            return (Automovil) query.getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<Automovil> obtenerAutomovilPorNumeroSerieLista(String numeroSerie) {
    EntityManager em = emf.createEntityManager();
    try {
        String sql = "SELECT * FROM automoviles WHERE UPPER(numero_serie) = ?";
        Query query = em.createNativeQuery(sql, Automovil.class);
        query.setParameter(1, numeroSerie.toUpperCase());
        return query.getResultList();
    } finally {
        em.close();
    }
}

    public Automovil obtenerAutomovilPorNumPlaca(String numPlaca) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p.automovil FROM Placa p WHERE p.numeroPlaca = :numPlaca");
            query.setParameter("numPlaca", numPlaca);
            return (Automovil) query.getResultList();
        } catch (NoResultException e) {

            return null;
        }
    }

}
