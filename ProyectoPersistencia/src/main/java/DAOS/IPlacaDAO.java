/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

import entidadesJPA.Placa;

/**
 *
 * @author ruben
 */

/**
 * Interfaz que define un método para acceder y manipular la persistencia de las placas en la base de datos
 */
public interface IPlacaDAO {
    
    /**
     * Método para guardar una placa en la base de datos
     * @param placa La placa a guardar
     */
    void guardarPlaca(Placa placa);
}
