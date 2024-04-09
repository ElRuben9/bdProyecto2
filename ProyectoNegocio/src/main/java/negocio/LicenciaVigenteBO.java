/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import entidadesJPA.Licencia;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author ruben
 */

// Clase para la lógica de negocio relacionada con la obtención de licencias vigentes
public class LicenciaVigenteBO {

    @PersistenceContext
    private EntityManager entityManager;

     // Constructor que recibe un EntityManager como parámetro
    public LicenciaVigenteBO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

     // Método para obtener una licencia vigente dado su número de licencia
    public Licencia obtenerLicenciaVigente(String numeroLicencia) {
        
        // Obtenemos la fecha actual
        Date fechaActual = new Date();
        
        // Creamos una consulta JPQL para obtener la licencia vigente
        Query query = entityManager.createQuery("SELECT l FROM Licencia l WHERE l.numeroLicencia = :numeroLicencia AND l.vigencia > :fechaActual");
        query.setParameter("numeroLicencia", numeroLicencia);
        query.setParameter("fechaActual", fechaActual);
        
        
        Licencia licencia = null;
        try {
            // Intentamos obtener el resultado de la consulta
            licencia = (Licencia) query.getSingleResult();
        } catch (Exception e) {
            // Si no se encuentra ninguna licencia vigente, se captura la excepción
        }
        return licencia;
    }
}
