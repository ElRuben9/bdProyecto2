/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

/**
 *
 * @author ruben
 */
// Interfaz para la lógica de negocio de consulta de personas
public interface IConsultaPersonaBO {
    
    // Método para verificar si existe una persona con el RFC proporcionado
    Boolean existePersonaConRFC(String rfc);
}
