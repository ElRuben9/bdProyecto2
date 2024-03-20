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

public interface IConsultaLicenciaBO {
    LicenciaDTO consultarLicenciaPorId(Long id);
  
}
