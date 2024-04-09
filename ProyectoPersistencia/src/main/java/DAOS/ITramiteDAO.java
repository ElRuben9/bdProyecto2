/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

import entidadesJPA.Tramite;

/**
 *
 * @author ruben
 */

   /**
    * Interfaz que define un método para acceder y manipular la persistencia de trámites en la base de datos
    */
     public interface ITramiteDAO {
         
     /**
     * Método para guardar un trámite en la base de datos
     *
     * @param tramite El trámite a guardar
     */    
      void guardarTramite(Tramite tramite);
}
