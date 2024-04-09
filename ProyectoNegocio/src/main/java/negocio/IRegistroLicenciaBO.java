/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

/**
 *
 * @author ruben
 */
import dto.NuevoLicenciaDTO;
import entidadesJPA.Licencia;
import entidadesJPA.Persona;


// Interfaz para la lógica de negocio de registro de licencias
public interface IRegistroLicenciaBO {

    
    // Método para registrar una nueva licencia
    Licencia registrarLicencia(NuevoLicenciaDTO nuevoLicenciaDTO);
    
    
    // Método para validar datos de una persona
     boolean validarDatos(Persona persona);
    
    
}
