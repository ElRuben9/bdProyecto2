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

public interface IPersonaDAO {

    void guardarPersona(Persona persona);

    Persona obtenerPersonaPorId(Long id);

    void actualizarPersona(Persona persona);

    void eliminarPersona(Long id);
}
