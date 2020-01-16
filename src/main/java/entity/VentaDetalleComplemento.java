/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author claudia.santosusam
 */
@Entity
@Table(name = "ventadetalle_complemento")
public class VentaDetalleComplemento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idventaDetalle_complemento;

    @ManyToOne
    @JoinColumn(name = "idventa_detalle", referencedColumnName = "idventa_detalle")
    private Venta_Detalle idventa_detalle;

    @ManyToOne
    @JoinColumn(name = "idcomplemento", referencedColumnName = "idcomplemento")
    private Complemento idcomplemento;
    
    @Column(name="cantidad",nullable = false)
    private int cantidad;

    public int getIdventaDetalle_complemento() {
        return idventaDetalle_complemento;
    }

    public void setIdventaDetalle_complemento(int idventaDetalle_complemento) {
        this.idventaDetalle_complemento = idventaDetalle_complemento;
    }

    public Venta_Detalle getIdventa_detalle() {
        return idventa_detalle;
    }

    public void setIdventa_detalle(Venta_Detalle idventa_detalle) {
        this.idventa_detalle = idventa_detalle;
    }

    public Complemento getIdcomplemento() {
        return idcomplemento;
    }

    public void setIdcomplemento(Complemento idcomplemento) {
        this.idcomplemento = idcomplemento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "VentaDetalleComplemento{" + "idventaDetalle_complemento=" + idventaDetalle_complemento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idventaDetalle_complemento;
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
        final VentaDetalleComplemento other = (VentaDetalleComplemento) obj;
        if (this.idventaDetalle_complemento != other.idventaDetalle_complemento) {
            return false;
        }
        return true;
    }
    
    
    

}
