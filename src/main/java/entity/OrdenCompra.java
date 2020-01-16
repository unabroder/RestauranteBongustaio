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
@Table(name = "orden_compra")
public class OrdenCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorden_compra")
    private int idorden_compra;

    @ManyToOne
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    private Proveedor idproveedor;

    @ManyToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    private Producto idproducto;

    @ManyToOne
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    private Sucursal idsucursal;

    @Column(name = "cantidad")
    private int cantidad;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado")
    private int estado = 1;

    public int getIdorden_compra() {
        return idorden_compra;
    }

    public void setIdorden_compra(int idorden_compra) {
        this.idorden_compra = idorden_compra;
    }

    public Proveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedor idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        int hash = 3;
        hash = 89 * hash + this.idorden_compra;

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
        final OrdenCompra other = (OrdenCompra) obj;
        if (this.idorden_compra != other.idorden_compra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" + "idorden_compra=" + idorden_compra + '}';
    }

}
