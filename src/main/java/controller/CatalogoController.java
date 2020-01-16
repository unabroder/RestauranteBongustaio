/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.CatalogoFacadeLocal;
import ejb.TipoproductoFacadeLocal;
import entity.Catalogo;
import entity.Tipoproducto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "catalogoController")
@SessionScoped
public class CatalogoController implements Serializable {

    @EJB
    private CatalogoFacadeLocal catalogoEJB;
    private Catalogo catalogo;
    private List<Catalogo> listaCatalogo;

    @EJB
    private TipoproductoFacadeLocal tipoproductoEJB;
    private Tipoproducto tipoproducto;
    private List<Tipoproducto> listaTipoproducto;

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public List<Catalogo> getListaCatalogo() {
        this.listaCatalogo = catalogoEJB.findAll();
        return listaCatalogo;
    }

    public void setListaCatalogo(List<Catalogo> listaCatalogo) {
        this.listaCatalogo = listaCatalogo;
    }

    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public List<Tipoproducto> getListaTipoproducto() {
        this.listaTipoproducto = this.tipoproductoEJB.findAll();
        return listaTipoproducto;
    }

    public void setListaTipoproducto(List<Tipoproducto> listaTipoproducto) {
        this.listaTipoproducto = listaTipoproducto;
    }

    @PostConstruct
    public void init() {
        catalogo = new Catalogo();
        tipoproducto = new Tipoproducto();
    }

    public void consultarCatalogo() {
        try {
            listaCatalogo = catalogoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void consultarTipoproducto() {
        try {

            listaTipoproducto = tipoproductoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            catalogo.setIdtipoproduc(tipoproducto);
            catalogoEJB.create(catalogo);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se guardo correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }

    public void consultar() {
        try {
            listaCatalogo = catalogoEJB.findAll();
            listaTipoproducto = tipoproductoEJB.findAll();

        } catch (Exception e) {
        }
    }

    public void listar() {
        try {
            listaCatalogo = catalogoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void leerid(Catalogo cata) {
        try {
            this.tipoproducto.setIdtipoproducto(cata.getIdtipoproduc().getIdtipoproducto());
            this.catalogo = cata;

        } catch (Exception e) {
        }
    }

    public void modificar() {
        try {
            catalogoEJB.edit(catalogo);
            listaCatalogo = catalogoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void eliminar(Catalogo cata) {
        this.catalogo = cata;
        try {
            catalogoEJB.remove(catalogo);
            listaCatalogo = catalogoEJB.findAll();

        } catch (Exception e) {
        }
    }

    public void consultarById(Catalogo catalogo) {
        try {
            this.catalogo = catalogo;
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        try {
            catalogo = new Catalogo();
            tipoproducto = new Tipoproducto();
        } catch (Exception e) {
        }

    }
}
