
package com.Nexus.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="computadora")
public class Computadora {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComputadora;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo; 

    public Computadora() {
    }

    public Computadora(String descripcion, String detalle, double precio, int existencias, boolean activo) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
    
    
}
