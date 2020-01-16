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
import javax.persistence.Table;

/**
 *
 * @author roberto.alferesusam
 */
@Entity
@Table(name = "tipoempleado")
public class TipoEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipoempleado;
    @Column(name = "tipoempleado")
    private String tipoempleado;
    @Column(name = "estado")
    private int estado = 1;

    public int getIdtipoempleado() {
        return idtipoempleado;
    }

    public void setIdtipoempleado(int idtipoempleado) {
        this.idtipoempleado = idtipoempleado;
    }

    public String getTipoempleado() {
        return tipoempleado;
    }

    public void setTipoempleado(String tipoempleado) {
        this.tipoempleado = tipoempleado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idtipoempleado;
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
        final TipoEmpleado other = (TipoEmpleado) obj;
        if (this.idtipoempleado != other.idtipoempleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoEmpleado{" + "idtipoempleado=" + idtipoempleado + '}';
    }

}
