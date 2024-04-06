/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import entidadesJPA.Licencia;
import entidadesJPA.Placa;


/**
 *
 * @author ruben
 */
public interface ITramitePlacasNuevoBO {
    void realizarTramitePlacasNuevo(String numeroSerie, String marca, String linea, String color, int modelo, Licencia licencia);
    
    void cambiarPlacas(String numeroSerie, Placa nuevaPlaca);
}
