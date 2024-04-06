/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import entidadesJPA.Licencia;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LicenciaDAO implements ILicenciaDAO {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public LicenciaDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPU");
    }

    @Override
    public void guardarLicencia(Licencia licencia) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(licencia); // Guardar la licencia en la base de datos
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e; // Re-lanzar la excepción para que el llamador pueda manejarla
        } finally {
            em.close();
        }
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

    @Override
    public String generarNumeroLicencia() {

        // Obtener dos letras aleatorias del alfabeto
        char letra1 = (char) ('A' + (int) (Math.random() * 26));
        char letra2 = (char) ('A' + (int) (Math.random() * 26));

        // Obtener dos dígitos aleatorios para el día de nacimiento
        int dia = (int) (1 + Math.random() * 31); // Suponiendo el mes de enero

        // Obtener el año actual y restarle un número aleatorio entre 0 y 99
        int anio = LocalDate.now().getYear() - (int) (Math.random() * 100);

        // Generar un número secuencial aleatorio de 5 dígitos
        String secuencial = String.format("%05d", (int) (Math.random() * 100000));

        // Concatenar los componentes para formar el número de licencia
        String numeroLicencia = "" + letra1 + letra2 + String.format("%02d", dia) + anio + "-" + secuencial;

        return numeroLicencia;
    }
}
