/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ruben
 */

@Entity
@Table(name = "tramites")
public class Tramite implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_tramite")
    private Date fechaTramite;
    
    @Column(name = "tipo_tramite")
    private String tipoTramite;
  
    private double costo;
    
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    
    // Constructor por defecto de la clase Tramite
    public Tramite() {
    }

    
    
    /**
     * Constructor de la clase Tramite que inicializa todos los campos
     * @param id El identificador único del Tramite
     * @param fechaTramite La fecha en la que se realizó el Tramite
     * @param tipoTramite El tipo de Tramite realizado
     * @param costo El costo asociado al Tramite
     * @param persona La Persona que realizó el Tramite
     */
    public Tramite(Long id, Date fechaTramite, String tipoTramite, double costo, Persona persona) {
        this.id = id;
        this.fechaTramite = fechaTramite;
        this.tipoTramite = tipoTramite;
        this.costo = costo;
        this.persona = persona;
    }

    
    // Getters y Setters
    //Metodo getter que devuelve el valor  y metodo setter que establece el valor 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Date fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
}
