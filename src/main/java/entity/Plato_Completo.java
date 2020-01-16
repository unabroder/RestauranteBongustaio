
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
@Table(name="plato_completo")
public class Plato_Completo implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idplato_completo;

@Column(name="nombre",nullable = false)
private String nombre;

@Column(name="precio",nullable = false)
private double precio;

@Column(name="estado",nullable = false)
private int estado;
    
@ManyToOne
@JoinColumn(name="idcatalogo",referencedColumnName="idcatalogo")
private Catalogo idcatalogo;

@ManyToOne
@JoinColumn(name="idespecialidad",referencedColumnName = "idespecialidad")
private Especialidad idespecialidad;

// ========================================================================================================================
// ========================================================================================================================

    public int getIdplato_completo() {
        return idplato_completo;
    }

    public void setIdplato_completo(int idplato_completo) {
        this.idplato_completo = idplato_completo;
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

    public Catalogo getIdcatalogo() {
        return idcatalogo;
    }

    public void setIdcatalogo(Catalogo idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public Especialidad getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Especialidad idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

// ========================================================================================================================
// ========================================================================================================================

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.idplato_completo;
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
        final Plato_Completo other = (Plato_Completo) obj;
        if (this.idplato_completo != other.idplato_completo) {
            return false;
        }
        return true;
    }

// ========================================================================================================================

    @Override
    public String toString() {
        return "Plato_Completo{" + "idplato_completo=" + idplato_completo + ", nombre=" + nombre + ", precio=" + precio + ", estado=" + estado + ", idcatalogo=" + idcatalogo + ", idespecialidad=" + idespecialidad + '}';
    }

    
    
}
