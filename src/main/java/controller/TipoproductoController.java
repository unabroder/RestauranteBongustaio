/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.SucursalFacadeLocal;
import ejb.TipoproductoFacadeLocal;
import ejb.TiposucursalFacadeLocal;
import entity.Sucursal;
import entity.Tipoproducto;
import entity.Tiposucursal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "tipoproductoController")
@SessionScoped
public class TipoproductoController implements Serializable {

    @EJB
    private TipoproductoFacadeLocal tipoproductoEJB;
    private Tipoproducto tipoproducto;
    private List<Tipoproducto> listaTipoproducto;
    @EJB
    private TiposucursalFacadeLocal tiposucursalEJB;
    private Tiposucursal tiposucursal;
    private List<Tiposucursal> listaTiposucursal;

    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public List<Tipoproducto> getListaTipoproducto() {
        listaTipoproducto = tipoproductoEJB.findAll();
        return listaTipoproducto;
    }

    public Tiposucursal getTiposucursal() {
        return tiposucursal;
    }

    public void setTiposucursal(Tiposucursal tiposucursal) {
        this.tiposucursal = tiposucursal;
    }

    public List<Tiposucursal> getListaTiposucursal() {
        return listaTiposucursal;
    }

    public void setListaTiposucursal(List<Tiposucursal> listaTiposucursal) {
        this.listaTiposucursal = listaTiposucursal;
    }

    public void setListaTipoproducto(List<Tipoproducto> listaTipoproducto) {
        this.listaTipoproducto = listaTipoproducto;
    }

    @PostConstruct
    public void init() {
        tipoproducto = new Tipoproducto();
        tiposucursal = new Tiposucursal();
    }

    public void consultarTipoproducto() {
        try {
            listaTipoproducto = tipoproductoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        try {
            tipoproducto = new Tipoproducto();
            tiposucursal = new Tiposucursal();
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            tipoproducto.setIdtiposucursal(tiposucursal);
            tipoproductoEJB.create(tipoproducto);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se guardo exitosamente", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }

    public List<Tipoproducto> consultar() {

        this.listaTipoproducto = tipoproductoEJB.findAll();
        return listaTipoproducto;

    }

    public void listar() {
        try {
            listaTipoproducto = tipoproductoEJB.findAll();
        } catch (Exception e) {
        }
    }

 

    public void actualizar() {
        try {
            tipoproducto.setEstado(1);
            tipoproducto.setIdtiposucursal(tiposucursal);
            tipoproductoEJB.edit(tipoproducto);
            listaTipoproducto = tipoproductoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void consultarActivos() {
        try {
            listaTipoproducto = tipoproductoEJB.findActivos();
        } catch (Exception e) {
        }
    }

    public void deshabilitar(Tipoproducto tipo) {
        try {
            tipo.setEstado(0);
            tipoproductoEJB.Estado(tipo);
            listaTipoproducto = tipoproductoEJB.findAll();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se deshabilitó su registro", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
        }
    }

    public void habilitar(Tipoproducto tipo) {
        try {
            tipo.setEstado(1);
            tipoproductoEJB.Estado(tipo);
            listaTipoproducto = tipoproductoEJB.findAll();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se habilitó su registro", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }

    public void consultarById(Tipoproducto tipo) {
        try {
            this.tiposucursal.setIdtiposucursal(tipo.getIdtiposucursal().getIdtiposucursal());
            this.tipoproducto = tipo;
        } catch (Exception e) {
        }
    }
}
