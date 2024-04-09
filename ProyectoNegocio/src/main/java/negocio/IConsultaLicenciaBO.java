/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

/**
 *
 * @author ruben
 */
import dto.LicenciaDTO;

// Interfaz para la lógica de negocio de consulta de licencias
public interface IConsultaLicenciaBO {
    
    // Método para consultar una licencia por su ID
    LicenciaDTO consultarLicenciaPorId(Long id);
  
}
