/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

import entidadesJPA.Automovil;

/**
 *
 * @author ruben
 */

/**
 * Interfaz que define métodos para acceder y manipular la persistencia de los automóviles en la base de datos
 */
public interface IAutomovilDAO {
    
    /**
     * Método para guardar un objeto Automovil en la base de datos
     *
     * @param automovil El objeto Automovil a guardar
     */
    void guardarAutomovil(Automovil automovil);
}
