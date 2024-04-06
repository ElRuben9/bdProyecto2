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
    
    public PlacaDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
    }
    
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
    
     // Método para desactivar las placas activas de un automóvil
    public void desactivarPlacasActivas(Automovil automovil) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
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


