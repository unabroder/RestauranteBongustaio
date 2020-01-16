/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ProductoFacadeLocal;
import entity.Producto;
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
 * @author claudia.santosusam
 */
@Named(value = "productoController")
@SessionScoped
public class ProductoController implements Serializable {

    @EJB
    private ProductoFacadeLocal productoEJB;
    private Producto producto;
    private List<Producto> listaproducto;
    private List<Producto> listaproducto2;

    public List<Producto> getListaproducto2() {
        this.listaproducto2 = productoEJB.Buscar(producto);
        return listaproducto2;
    }

    public void setListaproducto2(List<Producto> listaproducto2) {
        this.listaproducto2 = listaproducto2;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaproducto() {
        this.listaproducto = productoEJB.findAll();
        return listaproducto;
    }

    public void setListaproducto(List<Producto> listaproducto) {
        this.listaproducto = listaproducto;
    }

    @PostConstruct
    public void init() {
        producto = new Producto();

    }

    public void insertar() {
        try {
            productoEJB.create(producto);
            FacesMessage MSJ = new FacesMessage(FacesMessage.SEVERITY_INFO, "Su registro fue guardado", null);
            FacesContext.getCurrentInstance().addMessage(null, MSJ);
        } catch (Exception e) {
             FacesMessage MSJ = new FacesMessage(FacesMessage.SEVERITY_INFO, "Surgio un error al guardado", null);
            FacesContext.getCurrentInstance().addMessage(null, MSJ);
        }
        
    }

    public void listar() {
        try {
            this.listaproducto = productoEJB.findAll();
            
        } catch (Exception e) {
           
        }
      
    }

    public void leerid(Producto prod) {
        try {
            this.producto = prod;
        } catch (Exception e) {
        }

    }

    public void modificar() {
        try {
            productoEJB.edit(producto);
        } catch (Exception e) {
        }

    }

    public void eliminar(Producto prod) {
        this.producto = prod;
        try {
            productoEJB.remove(producto);
            listaproducto = productoEJB.findAll();
        } catch (Exception e) {
        }

    }
    public void limpiar(){
    producto=new Producto();
    
    }

}
