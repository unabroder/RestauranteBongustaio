/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.OrdenCompraFacadeLocal;
import ejb.SucursalFacadeLocal;
import ejb.TiposucursalFacadeLocal;
import entity.OrdenCompra;
import entity.Sucursal;
import entity.Tiposucursal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author juan.ruizusam
 */
@Named(value = "sucursalController")
@SessionScoped
public class SucursalController implements Serializable {

    @EJB
    private SucursalFacadeLocal sucursalEJB;
    private Sucursal sucursal;
    private List<Sucursal> listaSucursal;

    @EJB
    private TiposucursalFacadeLocal tsucursalEJB;
    private Tiposucursal tsucursal;
    private List<Tiposucursal> listaTsucursal;

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Sucursal> getListaSucursal() {

        listaSucursal = sucursalEJB.findAll();

        return listaSucursal;
    }

    public void setListaSucursal(List<Sucursal> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }

    public Tiposucursal getTsucursal() {
        return tsucursal;
    }

    public void setTsucursal(Tiposucursal tsucursal) {
        this.tsucursal = tsucursal;
    }

    public List<Tiposucursal> getListaTsucursal() {
        return listaTsucursal;
    }

    public void setListaTsucursal(List<Tiposucursal> listaTsucursal) {
        this.listaTsucursal = listaTsucursal;
    }



    @PostConstruct
    private void init() {
        sucursal = new Sucursal();
        tsucursal = new Tiposucursal();
    }

    public void insertar() {
        try {
            sucursal.setEstado(1);
            sucursal.setIdtipo(tsucursal);
            sucursalEJB.create(sucursal);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Su registro fue guardado", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }

    public void actualizar() {
        try {
            sucursal.setEstado(1);
            sucursal.setIdtipo(tsucursal);
            sucursalEJB.edit(sucursal);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Su registro fue guardado", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }

    public void deshabilitar(Sucursal sucu) {
        try {
            sucu.setEstado(0);
            sucursalEJB.Estado(sucu);
            listaSucursal = sucursalEJB.findAll();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se deshabilitó su registro", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }

    public void habilitar(Sucursal sucu) {
        try {
            sucu.setEstado(1);
            sucursalEJB.Estado(sucu);
            listaSucursal = sucursalEJB.findAll();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se habilitó su registro", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }

    public void consultarActivos() {
        try {
            listaSucursal = sucursalEJB.findAllActivo();
        } catch (Exception e) {
        }

    }

    public List<Sucursal> consultar() {

        this.listaSucursal = sucursalEJB.findAll();
        return listaSucursal;

    }

    public void consultarById(Sucursal sucursal) {
        try {
            this.sucursal = sucursal;
        } catch (Exception e) {
        }

    }

    public void limpiar() {

        sucursal = new Sucursal();
        tsucursal = new Tiposucursal();
    }
}
