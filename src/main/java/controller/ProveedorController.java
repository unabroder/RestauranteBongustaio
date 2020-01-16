package controller;

import ejb.ProveedorFacadeLocal;
import entity.Proveedor;
import entity.Sucursal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author joqtan.marmolusam
 */
@Named(value = "ProveedorController")
@SessionScoped
public class ProveedorController implements Serializable {

    @EJB
    private ProveedorFacadeLocal proveedorEJB;
    private Proveedor proveedor;
    private List<Proveedor> listaProveedor;


    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListaProveedor() {
        listaProveedor = proveedorEJB.findAll();
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    @PostConstruct
    public void init() {
        proveedor = new Proveedor();
    }

    public void consultarProveedor() {
        try {
            listaProveedor = proveedorEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            proveedorEJB.create(proveedor);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "el registro fue guardado", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }
    
    public void editar(){
        try {
            proveedorEJB.edit(proveedor);
        } catch (Exception e) {
        }
    }
    
    public void leerid(Proveedor prov) {
        try {
            this.proveedor = prov;
        } catch (Exception e) {
        }

    }
    
    public void eliminar(Proveedor prov){
        try {
            proveedor = prov;
            proveedorEJB.remove(proveedor);
        } catch (Exception e) {
        }
    }
    

    public void consultar() {
        try {
            listaProveedor = proveedorEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void limpiar(){
        this.proveedor = new Proveedor();
    }
}


