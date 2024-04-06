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

public class TramitePlacasNuevoBO {

    private AutomovilDAO automovilDAO;

    public TramitePlacasNuevoBO() {
        this.automovilDAO = new AutomovilDAO();
    }

    public void realizarTramitePlacasNuevo(String numeroSerie, String marca, String linea, String color, int modelo, Licencia licencia) {
        Automovil automovilExistente = automovilDAO.obtenerAutomovilPorNumeroSerie(numeroSerie);
        if (automovilExistente == null) {
            Automovil automovil = new Automovil(numeroSerie, marca, linea, color, modelo, null, new Date(), null);
            automovilDAO.guardarAutomovil(automovil);
        } else {
            System.out.println("El automóvil con número de serie " + numeroSerie + " ya está registrado.");
        }
    }

    public void cambiarPlacas(String numeroSerie, Placa nuevaPlaca) {
        Automovil automovil = automovilDAO.obtenerAutomovilPorNumeroSerie(numeroSerie);
        if (automovil != null) {
            automovil.setFechaRecepcion(new Date());
            automovilDAO.actualizarAutomovil(automovil);
        } else {
            System.out.println("No se encontró el automóvil con número de serie " + numeroSerie);
        }
    }
}
