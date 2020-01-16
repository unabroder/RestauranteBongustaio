package controller;

import ejb.CatalogoFacadeLocal;
import ejb.EspecialidadFacadeLocal;
import ejb.Plato_CompletoFacadeLocal;
import entity.Catalogo;
import entity.Especialidad;
import entity.Plato_Completo;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "plato_CompletoController")
@ViewScoped
public class Plato_CompletoController implements Serializable {

    @EJB
    private Plato_CompletoFacadeLocal pcompletoEJB;
    private Plato_Completo pcompleto;
    private List<Plato_Completo> listapcompleto;

    @EJB
    private CatalogoFacadeLocal catalogoEJB;
    private Catalogo catalogo;
    private List<Catalogo> listacatalogo;

    @EJB
    private EspecialidadFacadeLocal especialidadEJB;
    private Especialidad especialidad;
    private List<Especialidad> listaespecialidad;

    @PostConstruct
    private void init() {
        pcompleto = new Plato_Completo();
        especialidad = new Especialidad();
        catalogo = new Catalogo();
        // recogiendo el idTipoProducto que viene desde venta.xhtml
        String idTipoProductoStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTipoProducto");
        if(idTipoProductoStr != null && !idTipoProductoStr.isEmpty()){
            int idTipoProducto = Integer.parseInt(idTipoProductoStr);
            listapcompleto = pcompletoEJB.obtenerPlatoCompletoPorTipoProducto(idTipoProducto);
        }
    }
    
    public Plato_Completo getPcompleto() {
        return pcompleto;
    }

    public void setPcompleto(Plato_Completo pcompleto) {
        this.pcompleto = pcompleto;
    }

    public List<Plato_Completo> getListapcompleto() {
        if(listapcompleto == null || listapcompleto.isEmpty()){
            this.listapcompleto=pcompletoEJB.findAll();
        }
        return listapcompleto;
    }

    public void setListapcompleto(List<Plato_Completo> listapcompleto) {
        this.listapcompleto = listapcompleto;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public List<Catalogo> getListacatalogo() {
        return listacatalogo;
    }

    public void setListacatalogo(List<Catalogo> listacatalogo) {
        this.listacatalogo = listacatalogo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Especialidad> getListaespecialidad() {
        return listaespecialidad;
    }

    public void setListaespecialidad(List<Especialidad> listaespecialidad) {
        this.listaespecialidad = listaespecialidad;
    }

    public void consultarEspecialidad() {
        try {
            listaespecialidad = especialidadEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void consultarCatalogo() {
        try {
            listacatalogo = catalogoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            pcompleto.setIdcatalogo(catalogo);
            pcompleto.setIdespecialidad(especialidad);

            pcompletoEJB.create(pcompleto);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "su registro fue guardado", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }

    public void consultar() {
        try {
            listapcompleto = pcompletoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void leerId(Plato_Completo pcompleto) {
        try {
            this.catalogo.setIdcatalogo(pcompleto.getIdplato_completo());
            this.especialidad.setIdespecialidad(pcompleto.getIdespecialidad().getIdespecialidad());
            this.pcompleto = pcompleto;
        } catch (Exception e) {
        }
    }

    public void modificar() {
        try {
            pcompleto.setIdcatalogo(catalogo);
            pcompleto.setIdespecialidad(especialidad);

            pcompletoEJB.edit(pcompleto);
        } catch (Exception e) {
        }
    }

    public void eliminar(Plato_Completo pcompleto) {
        this.pcompleto = pcompleto;
        try {
            pcompletoEJB.remove(pcompleto);
            listapcompleto = pcompletoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
//        pcompleto = new Plato_Completo();
//        especialidad = new Especialidad();
//        catalogo = new Catalogo();
    }
    
    
}
