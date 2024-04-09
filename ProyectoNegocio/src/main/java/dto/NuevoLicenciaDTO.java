/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author ruben 
 */
import java.time.LocalDate;

public class NuevoLicenciaDTO {
    
    //Variables de instancia
    private String numeroLicencia;
    private LocalDate vigencia;
    private double costo;
    private LocalDate fechaExpedicion;
    private Long idPersona; 

    // Getter(metodo de acceso) sirve para obtener el valor de un campo privado desde fuera de su clase
    // Setter(metodo de modificacion) sirve para modificar el valor de un campo privado
    
    
    //Getter para el numero de licencia 
    public String getNumeroLicencia() {
        return numeroLicencia;
    }
    // Setter para el numero de licencia 
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    //Getter para vigencia 
    public LocalDate getVigencia() {
        return vigencia;
    }
    //Setter para vigencia 
    public void setVigencia(LocalDate vigencia) {
        this.vigencia = vigencia;
    }
    // Getter para Costo 
    public double getCosto() {
        return costo;
    }
    //Setter para Costo
    public void setCosto(double costo) {
        this.costo = costo;
    }
    // Getter para obtener la fecha de expedición de la licencia
    public LocalDate getFechaExpedicion() {
        return fechaExpedicion;
    }
     // Setter para establecer la fecha de expedición de la licencia
    public void setFechaExpedicion(LocalDate fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    // Getter para obtener el identificador de la persona asociada con la licencia
    public Long getIdPersona() {
        return idPersona;
    }
    // Setter para establecer el identificador de la persona asociada con la licencia
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    
}
