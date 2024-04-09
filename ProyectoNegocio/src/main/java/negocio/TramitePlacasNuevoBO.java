/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author ruben
 */
import entidadesJPA.Automovil;
import entidadesJPA.Licencia;
import DAOS.AutomovilDAO;
import entidadesJPA.Placa;
import java.util.Date;

// Clase para la lógica de negocio relacionada con los trámites de placas para vehículos nuevos
public class TramitePlacasNuevoBO {

    private AutomovilDAO automovilDAO;

     // Constructor que inicializa el AutomovilDAO
    public TramitePlacasNuevoBO() {
        this.automovilDAO = new AutomovilDAO();
    }
 // Método para realizar un trámite de placas para un vehículo nuevo
    public void realizarTramitePlacasNuevo(String numeroSerie, String marca, String linea, String color, int modelo, Licencia licencia) {
        
        // Verificar si el automóvil ya está registrado
        Automovil automovilExistente = automovilDAO.obtenerAutomovilPorNumeroSerie(numeroSerie);
        if (automovilExistente == null) {
            
             // Si el automóvil no está registrado, crear un nuevo automóvil
            Automovil automovil = new Automovil(numeroSerie, marca, linea, color, modelo, null, new Date(), null);
            automovilDAO.guardarAutomovil(automovil);
        } else {
            // Si el automóvil ya está registrado, mostrar un mensaje
            System.out.println("El automóvil con número de serie " + numeroSerie + " ya está registrado.");
        }
    }
     // Método para cambiar las placas de un vehículo
    public void cambiarPlacas(String numeroSerie, Placa nuevaPlaca) {
        
         // Obtener el automóvil por su número de serie.
        Automovil automovil = automovilDAO.obtenerAutomovilPorNumeroSerie(numeroSerie);
        if (automovil != null) {
            
             // Si se encuentra el automóvil, actualizar la fecha de recepción y guardar los cambios
            automovil.setFechaRecepcion(new Date());
            automovilDAO.actualizarAutomovil(automovil);
        } else {
             // Si no se encuentra el automóvil, mostrar un mensaje
            System.out.println("No se encontró el automóvil con número de serie " + numeroSerie);
        }
    }
}
