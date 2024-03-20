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
import javax.persistence.PersistenceContext;

public class PersonaDAO implements IPersonaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardarPersona(Persona persona) {
        entityManager.persist(persona);
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return entityManager.find(Persona.class, id);
    }

    @Override
    public void actualizarPersona(Persona persona) {
        entityManager.merge(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        Persona persona = entityManager.find(Persona.class, id);
        if (persona != null) {
            entityManager.remove(persona);
        }
    }
}
