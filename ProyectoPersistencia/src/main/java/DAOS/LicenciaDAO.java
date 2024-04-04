/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import entidadesJPA.Licencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class LicenciaDAO implements ILicenciaDAO {

    private EntityManager entityManager;
    private EntityManagerFactory emf;
    
    public LicenciaDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPU"); 
    }
    @Override
    public void guardarLicencia(Licencia licencia) {
        entityManager.persist(licencia);
    }

    @Override
    public Licencia obtenerLicenciaPorId(Long id) {
        return entityManager.find(Licencia.class, id);
    }

    @Override
    public void actualizarLicencia(Licencia licencia) {
        entityManager.merge(licencia);
    }

    @Override
    public void eliminarLicencia(Long id) {
        Licencia licencia = entityManager.find(Licencia.class, id);
        if (licencia != null) {
            entityManager.remove(licencia);
        }
    }
}
