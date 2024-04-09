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
import entidadesJPA.Placa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PlacaDAO implements IPlacaDAO {
    
    private EntityManagerFactory emf;
    
    /**
     * Constructor que inicializa el EntityManagerFactory
     */
    public PlacaDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
    }
    
    /**
     * Método para guardar una placa en la base de datos
     * @param placa La placa a guardar
     */
    @Override
    public void guardarPlaca(Placa placa) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(placa);
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
    
    /**
     * Método para desactivar las placas activas de un automóvil
     * @param automovil El automóvil del cual se desactivarán las placas activas
     */
    public void desactivarPlacasActivas(Automovil automovil) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // Actualizar el estado de las placas activas del automóvil a 'Inactivo'
            Query query = em.createQuery("UPDATE Placa p SET p.estado = 'Inactivo' WHERE p.automovil = :automovil AND p.estado = 'Activo'");
            query.setParameter("automovil", automovil);
            query.executeUpdate();
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
}