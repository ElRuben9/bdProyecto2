/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ruben
 */
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "placas")
public class Placa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_placa")
    private String numeroPlaca;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_recepcion")
    private Date fechaRecepcion;

    private double costo;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "automovil_id")
    private Automovil automovil;

    
    /**
     * Constructor por defecto de la clase Placa.
     */
    public Placa() {
    }
    
    /**
     * Constructor que inicializa una instancia de Placa con todos los campos
     *
     * @param id El identificador de la placa
     * @param numeroPlaca El número de la placa
     * @param fechaEmision La fecha de emisión de la placa
     * @param fechaRecepcion La fecha de recepción de la placa
     * @param costo El costo de la placa
     * @param estado El estado de la placa
     * @param automovil El automóvil asociado a la placa
     */
    public Placa(Long id, String numeroPlaca, Date fechaEmision, Date fechaRecepcion, 
            double costo, String estado, Automovil automovil) {
        this.id = id;
        this.numeroPlaca = numeroPlaca;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costo = costo;
        this.estado = estado;
        this.automovil = automovil;
    }

    
    
    /**
     * Constructor que inicializa una instancia de Placa con todos los campos excepto el identificador
     *
     * @param numeroPlaca El número de la placa
     * @param fechaEmision La fecha de emisión de la placa
     * @param fechaRecepcion La fecha de recepción de la placa
     * @param costo El costo de la placa
     * @param estado El estado de la placa
     * @param automovil El automóvil asociado a la placa
     */
    public Placa(String numeroPlaca, Date fechaEmision, Date fechaRecepcion, 
            double costo, String estado, Automovil automovil) {
        this.numeroPlaca = numeroPlaca;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costo = costo;
        this.estado = estado;
        this.automovil = automovil;
    }

    
    // Getters y Setters
    //Metodo getter que devuelve el valor  y metodo setter que establece el valor 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

}
