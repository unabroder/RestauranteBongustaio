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
@Table(name = "venta")
public class Venta implements Serializable {

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idventa;

    @ManyToOne
    @JoinColumn(name = "idplato_completo", referencedColumnName = "idplato_completo")
    private Plato_Completo platoCompleto;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "idcomplemento", referencedColumnName = "idcomplemento")
    private Complemento complemento;
    
    @ManyToOne
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    private Empleado empleado;
    
    @Column(name = "total", nullable = false)
    private Double total;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha = new Date();
    
    @Column(name = "estado", nullable = false)
    private int estado = 1;

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Plato_Completo getPlatoCompleto() {
        return platoCompleto;
    }

    public void setPlatoCompleto(Plato_Completo platoCompleto) {
        this.platoCompleto = platoCompleto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
    public String toString() {
        return "Venta{" + "idventa=" + idventa + ", platoCompleto=" + platoCompleto + ", cantidad=" + cantidad + ", complemento=" + complemento + ", empleado=" + empleado + ", total=" + total + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

}
