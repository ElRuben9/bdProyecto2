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
public class LicenciaVigenteBO {

    @PersistenceContext
    private EntityManager entityManager;

    public LicenciaVigenteBO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Licencia obtenerLicenciaVigente(String numeroLicencia) {
        Date fechaActual = new Date();
        Query query = entityManager.createQuery("SELECT l FROM Licencia l WHERE l.numeroLicencia = :numeroLicencia AND l.vigencia > :fechaActual");
        query.setParameter("numeroLicencia", numeroLicencia);
        query.setParameter("fechaActual", fechaActual);
        Licencia licencia = null;
        try {
            licencia = (Licencia) query.getSingleResult();
        } catch (Exception e) {
            
        }
        return licencia;
    }
}
