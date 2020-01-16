/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.BitacoraFacadeLocal;
import ejb.UsuariosFacadeLocal;
import entity.Bitacora;
import entity.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author roberto.alferesusam
 */
@Named(value = "bitacoraController")
@SessionScoped
public class BitacoraController implements Serializable{
    @EJB
    private BitacoraFacadeLocal bitacoraEJB;
    private Bitacora bitacora;
    private List<Bitacora> lsBitacora;

    @EJB
    private UsuariosFacadeLocal usuariosEJB;
    private Usuarios usuario;
    private List<Usuarios> lsUsuarios;
    
    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    public List<Bitacora> getLsBitacora() {
        return lsBitacora;
    }

    public void setLsBitacora(List<Bitacora> lsBitacora) {
        this.lsBitacora = lsBitacora;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getLsUsuarios() {
        return lsUsuarios;
    }

    public void setLsUsuarios(List<Usuarios> lsUsuarios) {
        this.lsUsuarios = lsUsuarios;
    }
    
    @PostConstruct
    public void init(){
        bitacora = new Bitacora();
    }
    
    public void guardar(){
        try {
            bitacora.setUsuario(usuario);
            bitacoraEJB.create(bitacora);
        } catch (Exception e) {
        }
    }
}
