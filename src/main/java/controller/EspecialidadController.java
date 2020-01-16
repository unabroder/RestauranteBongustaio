/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.EspecialidadFacadeLocal;
import entity.Especialidad;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author claudia.santosusam
 */
@Named(value = "especialidadController")
@SessionScoped
public class EspecialidadController implements Serializable{
     @EJB
    private EspecialidadFacadeLocal especialidadEJB;
    private Especialidad especialidad;
    private List<Especialidad> listaEspecialidad;

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Especialidad> getListaEspecialidad() {
        this.listaEspecialidad = especialidadEJB.findAll();
        return listaEspecialidad;
    }

    public void setListaEspecialidad(List<Especialidad> listaEspecialidad) {
        this.listaEspecialidad = listaEspecialidad;
    }
    
    @PostConstruct
    public void init(){
        especialidad = new Especialidad();
    }
 public void insertar() {      // metodo para insertar 
        try {
            especialidadEJB.create(especialidad);
        } catch (Exception e) {
        }
    }
 
 
     public void listar() {      // metodo para insertar 
        try {
            this.listaEspecialidad = especialidadEJB.findAll();
        } catch (Exception e) {
        }
    }
     
     
      public void leerid(Especialidad espe) {
        try {
            this.especialidad = espe;
        } catch (Exception e) {
        }
        
    }
    
        public void modificar() {
        try {
            especialidadEJB.edit(especialidad);
            listaEspecialidad = especialidadEJB.findAll();
        } catch (Exception e) {
        }
    }
    
        public void eliminar(Especialidad espe){
    this.especialidad=espe;
        try {
           especialidadEJB.remove(especialidad);
           listaEspecialidad=especialidadEJB.findAll();
        } catch (Exception e) {
        }
}
        public void limpiar(){
        
        especialidad = new Especialidad();
        }
    
    
}
