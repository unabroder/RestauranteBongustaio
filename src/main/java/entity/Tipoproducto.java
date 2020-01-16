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

@Entity
@Table(name = "tipoproducto")
public class Tipoproducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipoproducto;

    @ManyToOne
    @JoinColumn(name = "idtiposucursal", referencedColumnName = "idtiposucursal")
    private Tiposucursal idtiposucursal;

    @Column(name = "nombre", nullable = true)
    private String nombre;

    @Column(name = "estado", nullable = true)
    private int estado;

    public int getIdtipoproducto() {
        return idtipoproducto;
    }

    public void setIdtipoproducto(int idtipoproducto) {
        this.idtipoproducto = idtipoproducto;
    }

    public Tiposucursal getIdtiposucursal() {
        return idtiposucursal;
    }

    public void setIdtiposucursal(Tiposucursal idtiposucursal) {
        this.idtiposucursal = idtiposucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idtipoproducto;
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
        final Tipoproducto other = (Tipoproducto) obj;
        if (this.idtipoproducto != other.idtipoproducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tipoproducto{" + "idtipoproducto=" + idtipoproducto + ", idtiposucursal=" + idtiposucursal + ", nombre=" + nombre + ", estado=" + estado + '}';
    }

}
