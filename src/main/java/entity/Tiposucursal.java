package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tiposucursal")

public class Tiposucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtiposucursal;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private int estado;


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idtiposucursal;
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
        final Tiposucursal other = (Tiposucursal) obj;
        if (this.idtiposucursal != other.idtiposucursal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tiposucursal{" + "idtiposucursal=" + idtiposucursal + '}';
    }

    public int getIdtiposucursal() {
        return idtiposucursal;
    }

    public void setIdtiposucursal(int idtiposucursal) {
        this.idtiposucursal = idtiposucursal;
    }

    public String getTipo() {
        return nombre;
    }

    public void setTipo(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
