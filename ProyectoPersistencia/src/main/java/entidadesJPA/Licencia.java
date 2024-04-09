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
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "licencia")
public class Licencia implements Serializable {

    @Column(name = "Numero_de_licencia", nullable = false)
    private String numeroLicencia;
    @Column(name = "vigencia", nullable = false)
    private Date vigencia;
    @Column(name = "costo", nullable = false)
    private double costo;
    @Column(name = "Fecha_de_expedicion", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaExpedicion;
    
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Licencia() {
    }

    /**
     * Constructor de la clase Licencia con todos los atributos
     *
     * @param numeroLicencia El número de la licencia
     * @param vigencia La fecha de vigencia de la licencia
     * @param costo El costo de la licencia
     * @param fechaExpedicion La fecha de expedición de la licencia
     * @param persona La persona asociada a la licencia
     * @param id El identificador de la licencia
     */
   
    public Licencia(String numeroLicencia, Date vigencia, double costo, Date fechaExpedicion, Persona persona, Long id) {
        this.numeroLicencia = numeroLicencia;
        this.vigencia = vigencia;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
        this.id = id;
    }
 
    
    /**
     * Constructor de la clase Licencia sin el identificador
     *
     * @param numeroLicencia El número de la licencia
     * @param vigencia La fecha de vigencia de la licencia
     * @param costo El costo de la licencia
     * @param fechaExpedicion La fecha de expedición de la licencia
     * @param persona La persona asociada a la licencia
     */
    public Licencia(String numeroLicencia, Date vigencia, double costo, Date fechaExpedicion, Persona persona) {
        this.numeroLicencia = numeroLicencia;
        this.vigencia = vigencia;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
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

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
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

    
    /**
    * Compara este objeto con otro objeto para determinar la igualdad
    * Dos objetos de tipo `Licencia` se consideran iguales si tienen el mismo identificador (`id`)
    * @param object El objeto con el que se va a comparar
    * @return true si los objetos son iguales, false en caso contrario
    */
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

    
    /**
     * Devuelve una representación de cadena del objeto.
     * La representación incluye el nombre de la clase y el valor del identificador (`id`) del objeto.
     * @return Una representación de cadena del objeto
     */
    @Override
    public String toString() {
        return "entidadesJPA.Licencia[ id=" + id + " ]";
    }

}
