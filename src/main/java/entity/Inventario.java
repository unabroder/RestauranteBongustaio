package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinventario")
    private int idinventario;

    @ManyToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    private Producto idproducto;

    @Column(name = "cant_entrada")
    private int cant_entrada;

    @Column(name = "cant_disponible")
    private int cant_disponible;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha = new Date();
    @Column(name = "estado")
    private int estado;

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public int getCant_entrada() {
        return cant_entrada;
    }

    public void setCant_entrada(int cant_entrada) {
        this.cant_entrada = cant_entrada;
    }

    public int getCant_disponible() {
        return cant_disponible;
    }

    public void setCant_disponible(int cant_disponible) {
        this.cant_disponible = cant_disponible;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash = 19 * hash + this.idinventario;
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
        final Inventario other = (Inventario) obj;
        if (this.idinventario != other.idinventario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventario{" + "idinventario=" + idinventario + '}';
    }

    
   
}
