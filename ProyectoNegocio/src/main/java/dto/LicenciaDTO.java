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

public class LicenciaDTO {
    
    //Variables de instancia
    private Long id;
    private String numeroLicencia;
    private LocalDate vigencia;
    private double costo;
    private LocalDate fechaExpedicion;
    private Long idPersona; 

     // Getter(metodo de acceso) sirve para obtener el valor de un campo privado desde fuera de su clase
     // Setter(metodo de modificacion) sirve para modificar el valor de un campo privado
    

    // Getter para el id
    public Long getId() {
        return id;
    }
     // Setter para el id
    public void setId(Long id) {
        this.id = id;
    }
    // Getter para el numero de licencia
    public String getNumeroLicencia() {
        return numeroLicencia;
    }
    // Setter para el numero de Licencia
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    // Getter para la fecha de vencimiento
    public LocalDate getVigencia() {
        return vigencia;
    }
    // Setter para la fecha de vencimiento 
    public void setVigencia(LocalDate vigencia) {
        this.vigencia = vigencia;
    }
    // Getter para el costo
    public double getCosto() {
        return costo;
    }
    // Setter para el costo 
    public void setCosto(double costo) {
        this.costo = costo;
    }
    // Getter oara la fecha de expedicion
    public LocalDate getFechaExpedicion() {
        return fechaExpedicion;
    }
    // Setter para la fecha de expedicion
    public void setFechaExpedicion(LocalDate fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    // Getter para el Id de la Persona
    public Long getIdPersona() {
        return idPersona;
    }
    // Setter para el Id de la Persona
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    
}