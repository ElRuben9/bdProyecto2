/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import entidadesJPA.Licencia;

/**
 *
 * @author ruben
 */
public interface ILicenciaVigenteBO {
    Licencia obtenerLicenciaVigente(String numeroLicencia);
}
