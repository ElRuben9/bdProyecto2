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

// Interfaz para la lógica de negocio de trámites relacionados con placas de vehículos nuevos
public interface ITramitePlacasNuevoBO {
    
    // Método para realizar un trámite de placas para un vehículo nuevo
    void realizarTramitePlacasNuevo(String numeroSerie, String marca, String linea, String color, 
            int modelo, Licencia licencia);
    
    // Método para cambiar las placas de un vehículo
    void cambiarPlacas(String numeroSerie, Placa nuevaPlaca);
}
