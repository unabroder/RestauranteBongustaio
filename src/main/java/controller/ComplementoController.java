/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ComplementoFacadeLocal;
import entity.Complemento;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;

/**
 *
 * @author claudia.santosusam
 */
@Named(value = "complementoController")
@SessionScoped

public class ComplementoController implements Serializable {

    @EJB
    private ComplementoFacadeLocal complementoEJB;
    private Complemento complemento;
    private List<Complemento> listaComplemento;

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public List<Complemento> getListaComplemento() {
        this.listaComplemento= complementoEJB.findAll();
        return listaComplemento;
    }

    public void setListaComplemento(List<Complemento> listaComplemento) {
        this.listaComplemento = listaComplemento;
    }

    @PostConstruct
    public void init() {
        complemento = new Complemento();
    }

    public void insertar() {      // metodo para insertar 
        try {
            complementoEJB.create(complemento);
        } catch (Exception e) {
        }
    }

    public void listar() {      // metodo para insertar 
        try {
            this.listaComplemento = complementoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void leerid(Complemento compl) {
        try {
            this.complemento = compl;
        } catch (Exception e) {
        }

    }

    public void modificar() {
        try {
            complementoEJB.edit(complemento);
            listaComplemento = complementoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void eliminar(Complemento comple) {
        this.complemento = comple;
        try {
            complementoEJB.remove(complemento);
            listaComplemento = complementoEJB.findAll();

        } catch (Exception e) {
        }
    }

    public void limpiar() {

        complemento = new Complemento();
    }

}
