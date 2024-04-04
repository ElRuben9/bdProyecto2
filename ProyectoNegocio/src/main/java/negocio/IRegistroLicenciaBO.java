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

public interface IRegistroLicenciaBO {

    Licencia registrarLicencia(NuevoLicenciaDTO nuevoLicenciaDTO);
    
     boolean validarDatos(Persona persona);
    
    
}
