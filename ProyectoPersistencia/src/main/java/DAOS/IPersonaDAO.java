/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

/**
 *
 * @author ruben
 */
import entidadesJPA.Persona;

    /**
     * Interfaz que define métodos para acceder y manipular la persistencia de las personas en la base de datos
     */
     public interface IPersonaDAO {

    /**
     * Método para guardar una persona en la base de datos
     * @param persona La persona a guardar.
     */
    void guardarPersona(Persona persona);

    /**
     * Método para obtener una persona por su identificador único
     * @param id El identificador único de la persona a obtener
     * @return La persona encontrada, o null si no se encuentra ninguna persona con el ID dado
     */
    Persona obtenerPersonaPorId(Long id);

    /**
     * Método para actualizar una persona en la base de datos
     * @param persona La persona a actualizar
     */
    void actualizarPersona(Persona persona);

    /**
     * Método para eliminar una persona de la base de datos
     * @param id El identificador único de la persona a eliminar
     */
    void eliminarPersona(Long id);
}
