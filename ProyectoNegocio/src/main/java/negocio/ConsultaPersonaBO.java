/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import entidadesJPA.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ruben
 */
public class ConsultaPersonaBO {

    private EntityManagerFactory emf;

    public ConsultaPersonaBO() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
    }

    public Persona obtenerPersonaPorRFC(String rfc) {
    EntityManager entityManager = emf.createEntityManager();
    try {
        // Consulta para obtener la persona con el RFC dado
        Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.RFC = :rfc", Persona.class);
        query.setParameter("rfc", rfc);
        List<Persona> personas = query.getResultList();
        
        // Verificar si se encontró alguna persona con el RFC especificado
        if (!personas.isEmpty()) {
            // Devolver la primera persona encontrada (asumiendo que el RFC es único)
            return personas.get(0);
        } else {
           // No se encontró ninguna persona con el RFC especificado 
            return null; 
        }
    } finally {
        entityManager.close();
    }
}
}
