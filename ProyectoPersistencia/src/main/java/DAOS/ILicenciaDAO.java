/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

/**
 *
 * @author ruben
 */
import entidadesJPA.Licencia;

public interface ILicenciaDAO {

    void guardarLicencia(Licencia licencia);

    Licencia obtenerLicenciaPorId(Long id);

    void actualizarLicencia(Licencia licencia);

    void eliminarLicencia(Long id);
}
