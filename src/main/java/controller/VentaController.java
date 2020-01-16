package controller;

import ejb.ComplementoFacadeLocal;
import ejb.EmpleadoFacadeLocal;
import ejb.Plato_CompletoFacadeLocal;
import ejb.UsuariosFacadeLocal;
import ejb.VentaFacadeLocal;
import entity.Empleado;
import entity.Venta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import entity.Complemento;
import entity.Fechas;
import entity.Plato_Completo;
import entity.Usuarios;
import java.util.Iterator;

@Named(value = "ventaController")
@SessionScoped
public class VentaController implements Serializable {

    @EJB
    private VentaFacadeLocal ventaEJB;
    private Venta venta;
    private List<Venta> listaventa;
    private List<Venta> lsventa;

    @EJB
    private EmpleadoFacadeLocal empleadoEJB;
    private Empleado empleado;
    private List<Empleado> listaempleado;

    @EJB
    private Plato_CompletoFacadeLocal platoCompletoEJB;
    private Plato_Completo plato_Completo;
    private Plato_Completo platoCompleto;
    private List<Plato_Completo> listaPlatoCompleto;
    private List<Plato_Completo> listapcompleto;

    @EJB
    private ComplementoFacadeLocal complementoEJB;
    private Complemento complemento;
    private List<Complemento> listaComplemento;

    @EJB
    private UsuariosFacadeLocal usuarioEJB;
    private Usuarios usuarios;
    private List<Usuarios> lsUsuarios;

    private Fechas fecha;

    public Fechas getFecha() {
        return fecha;
    }

    public void setFecha(Fechas fecha) {
        this.fecha = fecha;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getLsventa() {
        this.lsventa = ventaEJB.consultarVenta(fecha.getFecha1(), fecha.getFecha2());
        return lsventa;
    }

    public void setLsventa(List<Venta> lsventa) {
        this.lsventa = lsventa;
    }

    public List<Venta> getListaventa() {

        return listaventa;
    }

    public void setListaventa(List<Venta> listaventa) {
        this.listaventa = listaventa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getListaempleado() {
        return listaempleado;
    }

    public void setListaempleado(List<Empleado> listaempleado) {
        this.listaempleado = listaempleado;
    }

    public Plato_Completo getPlato_Completo() {
        return plato_Completo;
    }

    public void setPlato_Completo(Plato_Completo plato_Completo) {
        this.plato_Completo = plato_Completo;
    }

    public List<Plato_Completo> getListaPlatoCompleto() {
        return listaPlatoCompleto;
    }

    public void setListaPlatoCompleto(List<Plato_Completo> listaPlatoCompleto) {
        if (listapcompleto == null || listapcompleto.isEmpty()) {
            this.listapcompleto = this.platoCompletoEJB.findAll();
        }
        this.listaPlatoCompleto = listaPlatoCompleto;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public List<Complemento> getListaComplemento() {
        return listaComplemento;
    }

    public void setListaComplemento(List<Complemento> listaComplemento) {
        this.listaComplemento = listaComplemento;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuarios> getLsUsuarios() {
        return lsUsuarios;
    }

    public void setLsUsuarios(List<Usuarios> lsUsuarios) {
        this.lsUsuarios = lsUsuarios;
    }

    public List<Plato_Completo> getListapcompleto() {
        return listapcompleto;
    }

    public void setListapcompleto(List<Plato_Completo> listapcompleto) {
        this.listapcompleto = listapcompleto;
    }

    public Plato_Completo getPlatoCompleto() {
        return platoCompleto;
    }

    public void setPlatoCompleto(Plato_Completo platoCompleto) {
        this.platoCompleto = platoCompleto;
    }

    @PostConstruct
    private void init() {
        venta = new Venta();
        empleado = new Empleado();
        plato_Completo = new Plato_Completo();
        platoCompleto = new Plato_Completo();
        complemento = new Complemento();
        fecha = new Fechas();
        String idTipoProductoStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTipoProducto");
        if (idTipoProductoStr != null && !idTipoProductoStr.isEmpty()) {
            int idTipoProducto = Integer.parseInt(idTipoProductoStr);
            listapcompleto = this.platoCompletoEJB.obtenerPlatoCompletoPorTipoProducto(idTipoProducto);
        }
      consultar();
    }

    public void consultarEmpleado() {
        try {
            this.listaempleado = empleadoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            System.out.println(plato_Completo);
            venta.setPlatoCompleto(plato_Completo);
            double precio;
            double total;
            this.listaPlatoCompleto = this.platoCompletoEJB.platoPrecio(plato_Completo);
            Iterator iter = listaPlatoCompleto.iterator();
            while (iter.hasNext()) {
                plato_Completo = (Plato_Completo) iter.next();
                System.out.println(plato_Completo.getPrecio());
            }
            System.out.println(empleado);
            int idusuario = empleado.getIdempleado();
            venta.setComplemento(complemento);
            this.listaComplemento = this.complementoEJB.precioComplemento(complemento);
            Iterator c = listaComplemento.iterator();
            while (c.hasNext()) {
                complemento = (Complemento) c.next();
                complemento.getPrecio();
            }
            this.lsUsuarios = this.usuarioEJB.obtenerEmp(idusuario);
            Iterator usu = lsUsuarios.iterator();
            while (usu.hasNext()) {
                usuarios = (Usuarios) usu.next();
                System.out.println(usuarios.getIdempleado().getIdempleado());
            }
            empleado.setIdempleado(usuarios.getIdempleado().getIdempleado());
            venta.setEmpleado(empleado);
            precio = plato_Completo.getPrecio();
            total = (venta.getCantidad() * precio) + complemento.getPrecio();
            venta.setTotal(total);
            System.out.println("total " + total);
            ventaEJB.create(venta);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "su registro fue guardado", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
        } catch (Exception e) {
        }
    }

    public void consultar() {
        try {
            listaventa = ventaEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void leerId(Venta vent) {
        try {
            this.empleado.setIdempleado(vent.getEmpleado().getIdempleado());
            this.plato_Completo.setIdplato_completo(vent.getPlatoCompleto().getIdplato_completo());
            this.complemento.setIdcomplemento(vent.getComplemento().getIdcomplemento());
            this.venta = vent;
        } catch (Exception e) {
        }
    }

    public void modificar() {
        try {
            venta.setEmpleado(empleado);
            venta.setPlatoCompleto(plato_Completo);
            venta.setComplemento(complemento);

            ventaEJB.edit(venta);
        } catch (Exception e) {
        }
    }

    public void eliminar(Venta vent) {
        this.venta = vent;
        try {
            ventaEJB.remove(venta);
            listaventa = ventaEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        venta = new Venta();
        empleado = new Empleado();
        plato_Completo = new Plato_Completo();
        platoCompleto = new Plato_Completo();
        complemento = new Complemento();
        fecha = new Fechas();
    }

    public void reporte() {
        try {
            Reporte reporte = new Reporte();
            reporte.reporte(this.lsventa);
        } catch (Exception e) {
        }
    }
}
