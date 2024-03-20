/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import DAOS.ILicenciaDAO;
import entidadesJPA.Licencia;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LicenciaDAO implements ILicenciaDAO {

    @PersistenceContext
    private EntityManager entityManager;

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
