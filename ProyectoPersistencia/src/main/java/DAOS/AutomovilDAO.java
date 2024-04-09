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
        // Iniciar una transacción
        tx.begin();
        
        // Asignar la fecha de emisión como la fecha actual
        automovil.setFechaEmision(new Date());
        
        // Asignar la fecha de recepción como null, ya que el automóvil acaba de ser guardado y no ha sido recibido aún
        automovil.setFechaRecepcion(null);
        
        // Persistir el objeto Automovil en la base de datos
        em.persist(automovil);
        
        // Commit la transacción para guardar los cambios en la base de datos
        tx.commit();
       } catch (Exception e) {
        // En caso de excepción, realizar un rollback de la transacción
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
       } finally {
        // Cerrar el EntityManager después de realizar la operación
        em.close();
       }
}

    /**
     * Método para actualizar un objeto Automovil en la base de datos.
     * @param automovil El objeto Automovil a actualizar.
     */
    public void actualizarAutomovil(Automovil automovil) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
        // Iniciar una transacción
        tx.begin();
        
        // Actualizar el objeto Automovil en la base de datos
        em.merge(automovil);
        
        // Commit la transacción para guardar los cambios en la base de datos
        tx.commit();
    } catch (Exception e) {
        // En caso de excepción, realizar un rollback de la transacción
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        // Cerrar el EntityManager después de realizar la operación
        em.close();
    }
}


      /**
       * Método para obtener un objeto Automovil por su número de serie
       * @param numeroSerie El número de serie del automóvil a buscar
       * @return El objeto Automovil encontrado, o null si no se encuentra
       */
    
       public Automovil obtenerAutomovilPorNumeroSerie(String numeroSerie) {
        EntityManager em = emf.createEntityManager();
         try {
        // Crear una consulta JPQL para seleccionar un automóvil por su número de serie
        Query query = em.createQuery("SELECT a FROM Automovil a WHERE a.numeroSerie = :numeroSerie");
        // Establecer el parámetro del número de serie en la consulta
        query.setParameter("numeroSerie", numeroSerie);
        // Ejecutar la consulta y devolver el resultado
        return (Automovil) query.getSingleResult();
    } catch (NoResultException e) {
        // Capturar la excepción NoResultException si no se encuentra ningún resultado
        return null;
    } finally {
        // Cerrar el EntityManager después de ejecutar la consulta
        em.close();
    }
}


    /**
     * Método para obtener una lista de objetos Automovil que coincidan con un número de serie dado
     * @param numeroSerie El número de serie de los automóviles a buscar
     * @return Una lista de objetos Automovil que coinciden con el número de serie dado
     */
    
    
       public List<Automovil> obtenerAutomovilPorNumeroSerieLista(String numeroSerie) {
        EntityManager em = emf.createEntityManager();
         try {
        // Consulta SQL para seleccionar automóviles con el número de serie dado
        String sql = "SELECT * FROM automoviles WHERE UPPER(numero_serie) = ?";
        // Crear una consulta nativa con la consulta SQL y mapear los resultados a objetos Automovil
        Query query = em.createNativeQuery(sql, Automovil.class);
        // Establecer el parámetro del número de serie en la consulta
        query.setParameter(1, numeroSerie.toUpperCase());
        // Ejecutar la consulta y devolver la lista de resultados
        return query.getResultList();
    } finally {
        // Cerrar el EntityManager después de ejecutar la consulta
        em.close();
    }
}

   /**
     * Método para obtener un objeto Automovil por su número de placa
     * @param numPlaca El número de placa del automóvil a buscar
     * @return El objeto Automovil encontrado, o null si no se encuentra
     */
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
