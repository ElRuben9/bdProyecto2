/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

/**
 *
 * @author ruben
 */
import entidadesJPA.Tramite;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TramiteDAO implements ITramiteDAO {
    
    private EntityManagerFactory emf;
    
    /**
     * Constructor que inicializa el EntityManagerFactory
     */
    public TramiteDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
    }
    
    /**
     * Método para guardar un trámite en la base de datos
     *
     * @param tramite El trámite a guardar
     */
    @Override
    public void guardarTramite(Tramite tramite) {
        
        // Crea un EntityManager para interactuar con la base de datos
        EntityManager em = emf.createEntityManager();
        
        // Inicia una transacción para asegurar la consistencia de los datos
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // Persiste el objeto Tramite en la base de datos
            em.persist(tramite);
            tx.commit();
        } catch (Exception e) {
            // En caso de excepción, realiza un rollback para deshacer los cambios
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();// Imprime la traza de la excepción
        } finally {
            em.close(); // Cierra el EntityManager para liberar recursos
        }
    }
}