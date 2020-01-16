
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
@Table(name = "venta_detalle")
public class Venta_Detalle implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idventa_detalle;
    
    @ManyToOne
    @JoinColumn(name="idplato_completo", referencedColumnName = "idplato_completo")
    private Plato_Completo idplato_completo;
    
    @Column(name="cantidad", nullable = false)
    private int cantidad;
    
    @Column(name="estado",nullable = false)
    private int estado;
    
    @Column(name = "codigo",nullable = false)
    private int codigo;
    
// =====================================================================================================================
// =======================================================================================================================

    public int getIdventa_detalle() {
        return idventa_detalle;
    }

    public void setIdventa_detalle(int idventa_detalle) {
        this.idventa_detalle = idventa_detalle;
    }

    public Plato_Completo getIdplato_completo() {
        return idplato_completo;
    }

    public void setIdplato_completo(Plato_Completo idplato_completo) {
        this.idplato_completo = idplato_completo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
// =====================================================================================================================
// =======================================================================================================================

    @Override
    public String toString() {
        return "Venta_Detalle{" + "idventa_detalle=" + idventa_detalle + ", idplato_completo=" + idplato_completo + ", cantidad=" + cantidad + ", estado=" + estado + ", codigo=" + codigo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idventa_detalle;
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
        final Venta_Detalle other = (Venta_Detalle) obj;
        if (this.idventa_detalle != other.idventa_detalle) {
            return false;
        }
        return true;
    }

    
    
}
