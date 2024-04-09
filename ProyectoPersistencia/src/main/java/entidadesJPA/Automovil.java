/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ruben
 */
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "automoviles")
public class Automovil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_serie")
    private String numeroSerie;

    private String marca;

    private String linea;

    private String color;

    private int modelo;

    @OneToMany(mappedBy = "automovil", cascade = CascadeType.ALL)
    private List<Placa> placas;

    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_recepcion")
    private Date fechaRecepcion;
    
    
    /**
     * Método constructor de la clase Automovil
     */
    public Automovil() {
    }
     
    
    /**
     * Constructor de la clase Automovil con parámetros
     *
     * @param numeroSerie El número de serie del automóvil
     * @param marca La marca del automóvil
     * @param linea La línea del automóvil
     * @param color El color del automóvil
     * @param modelo El modelo del automóvil
     * @param placas La lista de placas asociadas al automóvil
     * @param fechaEmision La fecha de emisión del automóvil
     * @param fechaRecepcion La fecha de recepción del automóvil
     */
    public Automovil(Long id, String numeroSerie, String marca, String linea, String color, 
            int modelo, List<Placa> placas, Date fechaEmision, Date fechaRecepcion) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.placas = placas;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
    }

    public Automovil(String numeroSerie, String marca, String linea, String color, 
            int modelo, List<Placa> placas, Date fechaEmision, Date fechaRecepcion) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.placas = placas;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
    }
    
     
    //Getters y Setters
     
     //Metodo getter que devuelve el valor y metodo setter que establece el valor 
    
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
    
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

}
