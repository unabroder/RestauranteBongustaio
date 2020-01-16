/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.TiposucursalFacadeLocal;
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
@Named(value = "tiposucursalController")
@SessionScoped
public class TiposucursalController implements Serializable {

   @EJB
   private TiposucursalFacadeLocal tsucursalEJB;
   private Tiposucursal tsucursal;
   private List<Tiposucursal> listaTsucursal;

    public Tiposucursal getTsucursal() {
        return tsucursal;
    }

    public void setTsucursal(Tiposucursal tsucursal) {
        this.tsucursal = tsucursal;
    }

    public List<Tiposucursal> getListaTsucursal() {
        this.listaTsucursal = tsucursalEJB.findAll();
        return listaTsucursal;
    }

    public void setListaTsucursal(List<Tiposucursal> listaTsucursal) {
        this.listaTsucursal = listaTsucursal;
    }
   
   @PostConstruct
   public void init(){
   tsucursal= new Tiposucursal();
   this.listaTsucursal=tsucursalEJB.findAll();
   }
   
   public void consultarById(){
   
       try {
           tsucursal=tsucursalEJB.find(tsucursal);
       } catch (Exception e) {
       }
   }
   
   public void consultar(){
   

           this.listaTsucursal=tsucursalEJB.findAll();
       
   }
   
   public void consultarActivos(){
   
       try {
           listaTsucursal=tsucursalEJB.findAllActivo();
       } catch (Exception e) {
       }
   }
   
   public void insertar(){
       try {
           tsucursalEJB.create(tsucursal);
           FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO, "su registro fue guardado", null);
           FacesContext.getCurrentInstance().addMessage(null, msg);
       } catch (Exception e) {
       }
       
   }
   
    public void actualizar(){
       try {
           tsucursalEJB.edit(tsucursal);
           FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO, "su registro fue guardado", null);
           FacesContext.getCurrentInstance().addMessage(null, msg);
       } catch (Exception e) {
       }
       
   }
    
     public void eliminar(){
       try {
           tsucursalEJB.removeEstado(tsucursal);
           FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO, "su registro fue guardado", null);
           FacesContext.getCurrentInstance().addMessage(null, msg);
       } catch (Exception e) {
       }
       
   }
      public void eliminarPermanente(){
       try {
           tsucursalEJB.remove(tsucursal);
           FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO, "su registro fue guardado", null);
           FacesContext.getCurrentInstance().addMessage(null, msg);
       } catch (Exception e) {
       }
       
   }
   
   
   
}
