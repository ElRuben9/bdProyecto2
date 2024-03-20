/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import javax.persistence.Temporal;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "licencia")
public class Licencia implements Serializable {
    @Column(name = "Numero_de_licencia", nullable = false, length = 9)  
    private String numeroLicencia;
    @Column(name = "vigencia", nullable = false)
    private LocalDate vigencia;
    @Column(name = "costo", nullable = false)
    private double costo;
    @Column(name = "Fecha_de_expedicion", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private LocalDate fechaExpedicion;
    @Column(name = "Persona", nullable = false)
    private Persona persona;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Licencia() {
    }

    public Licencia(String numeroLicencia, LocalDate vigencia, double costo, LocalDate fechaExpedicion, Persona persona, Long id) {
        this.numeroLicencia = numeroLicencia;
        this.vigencia = vigencia;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
        this.id = id;
    }

    public Licencia(String numeroLicencia, LocalDate vigencia, double costo, LocalDate fechaExpedicion, Persona persona) {
        this.numeroLicencia = numeroLicencia;
        this.vigencia = vigencia;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public LocalDate getVigencia() {
        return vigencia;
    }

    public void setVigencia(LocalDate vigencia) {
        this.vigencia = vigencia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(LocalDate fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidadesJPA.Licencia[ id=" + id + " ]";
    }
    
}
