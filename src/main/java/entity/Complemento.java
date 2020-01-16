/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author claudia.santosusam
 */
@Entity
@Named(value = "complemento")

public class Complemento implements Serializable{
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idcomplemento;
    
    @Column(name="nombre")
    private String nombre;
     
    @Column(name="precio")
    private double precio;

     
    @Column(name="estado")
    private int estado=1;
    
    

    public int getIdcomplemento() {
        return idcomplemento;
    }

    public void setIdcomplemento(int idcomplemento) {
        this.idcomplemento = idcomplemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idcomplemento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complemento other = (Complemento) obj;
        if (this.idcomplemento != other.idcomplemento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "complemento{" + "idcomplemento=" + idcomplemento + '}';
    }

    
}
