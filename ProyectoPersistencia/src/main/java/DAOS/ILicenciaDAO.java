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


/**
 * Interfaz que define métodos para acceder y manipular la persistencia de las licencias en la base de datos
 */
    public interface ILicenciaDAO {

    /**
     * Método para guardar una licencia en la base de datos
     *
     * @param licencia La licencia a guardar
     */
    void guardarLicencia(Licencia licencia);

    /**
     * Método para obtener una licencia por su identificador único
     * @param id El identificador único de la licencia a obtener
     * @return La licencia encontrada, o null si no se encuentra ninguna licencia con el ID dado
     */
    Licencia obtenerLicenciaPorId(Long id);

    /**
     * Método para actualizar una licencia en la base de datos
     * @param licencia La licencia a actualizar
     */
    void actualizarLicencia(Licencia licencia);

    /**
     * Método para eliminar una licencia de la base de datos
     * @param id El identificador único de la licencia a eliminar
     */
    void eliminarLicencia(Long id);
    
    /**
     * Método para generar un número de licencia único
     * @return El número de licencia generado
     */
    String generarNumeroLicencia();

    
    
}
